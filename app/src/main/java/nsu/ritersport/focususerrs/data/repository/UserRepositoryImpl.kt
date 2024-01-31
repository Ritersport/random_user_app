package nsu.ritersport.focususerrs.data.repository

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import nsu.ritersport.focususerrs.data.dao.LocationDao
import nsu.ritersport.focususerrs.data.dao.PicturesDao
import nsu.ritersport.focususerrs.data.dao.TimezoneDao
import nsu.ritersport.focususerrs.data.dao.UserDao
import nsu.ritersport.focususerrs.data.mappers.LocationMapper
import nsu.ritersport.focususerrs.data.mappers.UserMapper
import nsu.ritersport.focususerrs.data.model.LocationDto
import nsu.ritersport.focususerrs.data.model.PicturesDto
import nsu.ritersport.focususerrs.data.model.TimezoneDto
import nsu.ritersport.focususerrs.data.source.UsersAPI
import nsu.ritersport.focususerrs.data.source.models.ResultResponse
import nsu.ritersport.focususerrs.data.source.models.UserResponse
import nsu.ritersport.focususerrs.domain.model.SimpleUser
import nsu.ritersport.focususerrs.domain.model.User
import nsu.ritersport.focususerrs.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteService: UsersAPI,
    private val userDao: UserDao,
    private val locationDao: LocationDao,
    private val timezoneDao: TimezoneDao,
    private val picturesDao: PicturesDao,
) : UserRepository {

    override fun getSavedUsersList(): Single<List<SimpleUser>> =
        userDao.selectSimpleUsersList().map { it ->
            it.map {
                UserMapper.shortToDomain(it)
            }
        }


    override fun getUserById(id: String): Single<User> = userDao.selectFullUserById(id).map {
        UserMapper.fullToDomain(it)
    }

    override fun updateUsers(count: Int) =

        remoteService.getRandomUsers(count)
            .flatMapCompletable { Completable.fromCallable { addDataToDb(it) } }


    private fun addDataToDb(response: ResultResponse) {
        response.results.forEach {
            val tz = timezoneDao.insertTimezone(
                TimezoneDto(
                    0, it.location.timezone.offset, it.location.timezone.description
                )
            )
            val location = locationDao.insertLocation(LocationMapper.toEntity(it.location, tz))
            val pics = picturesDao.insertPicture(
                PicturesDto(
                    0, it.picture.large, it.picture.medium, it.picture.thumbnail
                )
            )
            userDao.insertUser(UserMapper.toEntity(it, location, pics))
        }
    }

    override fun deleteAll() = Completable.fromCallable {
        userDao.deleteUsers()
        picturesDao.deletePictures()
        locationDao.deleteLocations()
        timezoneDao.deleteTimezones()
    }
}
