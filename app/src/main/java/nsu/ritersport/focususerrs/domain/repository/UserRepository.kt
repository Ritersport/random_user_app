package nsu.ritersport.focususerrs.domain.repository

import io.reactivex.rxjava3.core.Single
import nsu.ritersport.focususerrs.domain.model.User

interface UserRepository {

    fun getUsers(count: Int): Single<List<User>>
}