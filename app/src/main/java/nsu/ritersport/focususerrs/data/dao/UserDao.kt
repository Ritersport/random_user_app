package nsu.ritersport.focususerrs.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.rxjava3.core.Single
import nsu.ritersport.focususerrs.data.model.FullInfoDto
import nsu.ritersport.focususerrs.data.model.ShortInfoDto
import nsu.ritersport.focususerrs.data.model.UserDto

@Dao
interface UserDao {

    @Query("SELECT uuid, titleName, firstName, lastName, gender, email, phone, " +
            "cell, birthdate, registrationDate, largePicture, postcode, country, state, city, street, " +
            "latitude, longitude,`offset`, description FROM " +
            "(SELECT * FROM " +
                "(SELECT * FROM users LEFT JOIN " +
                "pictures ON users.picsRef = pictures.picsId " +
                "WHERE uuid = :id)" +
            "LEFT JOIN " +
                "(SELECT * FROM locations LEFT JOIN " +
                "timezones ON locations.timezoneRef = timezones.timeId) " +
            "ON locationId = locationIdRef)")
    fun selectFullUserById(id: String): Single<FullInfoDto>

    @Query("SELECT uuid, titleName, firstName, lastName, phone, thumbnailPicture, country, state, city, street FROM " +
            "(SELECT * FROM users LEFT JOIN " +
            "pictures ON users.picsRef = pictures.picsId " +
            "LEFT JOIN " +
            "locations ON locationId = locationIdRef)")
    fun selectSimpleUsersList(): Single<List<ShortInfoDto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(userDto: UserDto)

    @Query("DELETE FROM users")
    fun deleteUsers()
}