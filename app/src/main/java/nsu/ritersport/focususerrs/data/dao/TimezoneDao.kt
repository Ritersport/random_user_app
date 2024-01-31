package nsu.ritersport.focususerrs.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import nsu.ritersport.focususerrs.data.model.TimezoneDto

@Dao
interface TimezoneDao {

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    fun insertTimezone(timezoneDto: TimezoneDto): Long

    @Query("DELETE FROM timezones")
    fun deleteTimezones()
}