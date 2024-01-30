package nsu.ritersport.focususerrs.di

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import nsu.ritersport.focususerrs.data.FocusUsersDatabase
import nsu.ritersport.focususerrs.data.dao.LocationDao
import nsu.ritersport.focususerrs.data.dao.PicturesDao
import nsu.ritersport.focususerrs.data.dao.TimezoneDao
import nsu.ritersport.focususerrs.data.dao.UserDao
import nsu.ritersport.focususerrs.data.repository.UserRepositoryImpl
import nsu.ritersport.focususerrs.data.source.RetrofitInstance
import nsu.ritersport.focususerrs.data.source.UsersAPI
import nsu.ritersport.focususerrs.domain.repository.UserRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindUsersRepository(impl: UserRepositoryImpl): UserRepository

    companion object {

        @Singleton
        @Provides
        fun provideDatabase(@ApplicationContext applicationContext: Context): FocusUsersDatabase {
            return Room.databaseBuilder(
                applicationContext,
                FocusUsersDatabase::class.java,
                "FUDatabase"
            ).build()
        }

        @Provides
        fun provideUserDao(focusUsersDatabase: FocusUsersDatabase): UserDao {
            return focusUsersDatabase.userDao()
        }

        @Provides
        fun provideLocationDao(focusUsersDatabase: FocusUsersDatabase): LocationDao {
            return focusUsersDatabase.locationDao()
        }

        @Provides
        fun provideTimezoneDao(focusUsersDatabase: FocusUsersDatabase): TimezoneDao {
            return focusUsersDatabase.timezoneDao()
        }

        @Provides
        fun providePicturesDao(focusUsersDatabase: FocusUsersDatabase): PicturesDao {
            return focusUsersDatabase.picturesDao()
        }

        @Singleton
        @Provides
        fun provideUsersAPI(): UsersAPI {
            return RetrofitInstance().api
        }
    }
}