package nsu.ritersport.focususerrs.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "locations",
    foreignKeys = [
        ForeignKey(
            entity = TimezoneDto::class,
            parentColumns = ["timeId"],
            childColumns = ["timezoneRef"]
        )
    ]
)
data class LocationDto(
    @PrimaryKey(autoGenerate = true) val locationId: Long = 0,
    val postcode: String,
    val country: String,
    val state: String,
    val city: String,
    val street: String,
    val latitude: Float,
    val longitude: Float,

    //refs
    val timezoneRef: Long,
)
