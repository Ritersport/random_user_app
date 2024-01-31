package nsu.ritersport.focususerrs.domain.repository

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import nsu.ritersport.focususerrs.domain.model.SimpleUser
import nsu.ritersport.focususerrs.domain.model.User

interface UserRepository {

    fun getSavedUsersList(): Single<List<SimpleUser>>

    fun getUserById(id: String): Single<User>

    fun updateUsers(count: Int): Completable

    fun deleteAll(): Completable

}