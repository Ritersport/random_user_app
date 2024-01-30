package nsu.ritersport.focususerrs.data.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import nsu.ritersport.focususerrs.data.model.LocationDto

interface LocationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLocation(locationDto: LocationDto): Int
}