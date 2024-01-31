package nsu.ritersport.focususerrs.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import nsu.ritersport.focususerrs.data.model.LocationDto

@Dao
interface LocationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLocation(locationDto: LocationDto): Long

    @Query("DELETE FROM locations")
    fun deleteLocations()
}