package nsu.ritersport.focususerrs.data.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import nsu.ritersport.focususerrs.data.model.TimezoneDto

interface TimezoneDao {

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    fun insertTimezone(timezoneDto: TimezoneDto): String
}