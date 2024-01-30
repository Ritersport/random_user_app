package nsu.ritersport.focususerrs.data.repository

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import nsu.ritersport.focususerrs.data.source.UsersAPI
import nsu.ritersport.focususerrs.domain.model.User
import nsu.ritersport.focususerrs.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteService: UsersAPI,
) : UserRepository {
    override fun getCachedUsers(): Single<List<User>> {
        TODO("Not yet implemented")
    }

    override fun updateUsers(count: Int): Completable {
        val data = remoteService.getRandomUsers(count)
        return Completable.complete()
    }
}