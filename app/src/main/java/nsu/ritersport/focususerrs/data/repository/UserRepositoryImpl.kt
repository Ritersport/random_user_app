package nsu.ritersport.focususerrs.data.repository

import io.reactivex.rxjava3.core.Single
import nsu.ritersport.focususerrs.data.source.UserService
import nsu.ritersport.focususerrs.domain.model.Gender
import nsu.ritersport.focususerrs.domain.model.Name
import nsu.ritersport.focususerrs.domain.model.Picture
import nsu.ritersport.focususerrs.domain.model.User
import nsu.ritersport.focususerrs.domain.model.location.Coordinates
import nsu.ritersport.focususerrs.domain.model.location.Location
import nsu.ritersport.focususerrs.domain.model.location.Street
import nsu.ritersport.focususerrs.domain.model.location.Timezone
import nsu.ritersport.focususerrs.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    //private val userService: UserService,
) : UserRepository {
    override fun getUsers(count: Int): Single<List<User>> {
        return Single.just(listOf(User(Gender.MALE, Name("wd", "wd", "de"), Location(Street(0, "a"), "d", "k", "jk", 56, Coordinates("", ""), Timezone("", "") ), "1", 1, 1, "78", Picture("", "", "https://randomuser.me/api/portraits/thumb/women/62.jpg"))))
    }
}