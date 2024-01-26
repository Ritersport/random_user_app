package nsu.ritersport.focususerrs.data.source

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import nsu.ritersport.focususerrs.domain.model.User
import nsu.ritersport.focususerrs.domain.services.UserService
import javax.inject.Inject

class UserServiceImpl @Inject constructor() : UserService {

    override fun getUsers(): Single<List<User>> {
        TODO("Not yet implemented")
    }

    override fun forceUpdate(): Completable {
        TODO("Not yet implemented")
    }
}