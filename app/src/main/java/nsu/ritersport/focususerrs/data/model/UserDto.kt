package nsu.ritersport.focususerrs.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "users",
    foreignKeys = [
        ForeignKey(
            entity = LocationDto::class,
            parentColumns = ["locationId"],
            childColumns = ["locationIdRef"]
        ),
        ForeignKey(
            entity = PicturesDto::class,
            parentColumns = ["picsId"],
            childColumns = ["picsRef"]
        )
    ]
)
data class UserDto(
    @PrimaryKey(autoGenerate = false) val uuid: String,
    val titleName: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val email: String,
    val phone: String,
    val cell: String,
    val birthdate: String,
    val registrationDate: String,

    //refs
    val locationIdRef: Long,
    val picsRef: Long,
)
