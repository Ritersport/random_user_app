package nsu.ritersport.focususerrs.data.source

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitInstance {
    val api: UsersAPI by lazy {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        Retrofit.Builder()
            .baseUrl("https://randomuser.me")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(UsersAPI::class.java)

    }
}