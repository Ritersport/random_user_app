package nsu.ritersport.focususerrs.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "timezones")
data class TimezoneDto(
    @PrimaryKey (autoGenerate = true) val timeId: Long = 0,
    val offset: String = "",
    val description: String,
)
