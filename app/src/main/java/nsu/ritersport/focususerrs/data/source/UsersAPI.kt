package nsu.ritersport.focususerrs.data.source

import io.reactivex.rxjava3.core.Single
import nsu.ritersport.focususerrs.data.source.models.ResultResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersAPI {

    @GET("api/")
    fun getRandomUsers(
        @Query("results") results: Int
    ): Single<ResultResponse>
}