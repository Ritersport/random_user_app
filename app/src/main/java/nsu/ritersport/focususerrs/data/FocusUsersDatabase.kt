package nsu.ritersport.focususerrs.data

import androidx.room.Database
import androidx.room.RoomDatabase
import nsu.ritersport.focususerrs.data.model.LocationDto
import nsu.ritersport.focususerrs.data.model.PicturesDto
import nsu.ritersport.focususerrs.data.model.TimezoneDto
import nsu.ritersport.focususerrs.data.model.UserDto

@Database(
    entities = [
        LocationDto::class,
        PicturesDto::class,
        TimezoneDto::class,
        UserDto::class
    ],
    version = 1
)
abstract class FocusUsersDatabase : RoomDatabase() {
    
}