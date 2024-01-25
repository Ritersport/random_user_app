package nsu.ritersport.focususerrs.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import nsu.ritersport.focususerrs.data.repository.UserRepositoryImpl
import nsu.ritersport.focususerrs.domain.repository.UserRepository


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindUsersRepository(impl: UserRepositoryImpl): UserRepository
}