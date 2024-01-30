package nsu.ritersport.focususerrs.domain.repository

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import nsu.ritersport.focususerrs.domain.model.User

interface UserRepository {

    fun getCachedUsers(): Single<List<User>>

    fun updateUsers(count: Int): Completable

}