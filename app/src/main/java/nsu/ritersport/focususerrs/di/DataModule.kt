package nsu.ritersport.focususerrs.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import nsu.ritersport.focususerrs.data.repository.UserRepositoryImpl
import nsu.ritersport.focususerrs.data.source.RetrofitInstance
import nsu.ritersport.focususerrs.data.source.UserServiceImpl
import nsu.ritersport.focususerrs.data.source.UsersAPI
import nsu.ritersport.focususerrs.domain.repository.UserRepository
import nsu.ritersport.focususerrs.domain.services.UserService
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindUsersRepository(impl: UserRepositoryImpl): UserRepository

    @Binds
    abstract fun bindUsersService(impl: UserServiceImpl): UserService

    companion object {
        @Singleton
        @Provides
        fun provideUsersAPI(): UsersAPI {
            return RetrofitInstance().api
        }
    }
}