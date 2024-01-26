package nsu.ritersport.focususerrs.domain.services

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import nsu.ritersport.focususerrs.domain.model.User

interface UserService {

    fun getUsers(): Single<List<User>>

    fun forceUpdate(): Completable
}