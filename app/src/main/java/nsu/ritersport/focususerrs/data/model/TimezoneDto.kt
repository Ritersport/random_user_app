package nsu.ritersport.focususerrs.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "timezones")
data class TimezoneDto(
    @PrimaryKey (autoGenerate = false) val offset: String = "",
    val description: String,
)
