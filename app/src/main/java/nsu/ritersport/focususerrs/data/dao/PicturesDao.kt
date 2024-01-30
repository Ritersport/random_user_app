package nsu.ritersport.focususerrs.data.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import nsu.ritersport.focususerrs.data.model.PicturesDto

interface PicturesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPicture(picturesDto: PicturesDto): Int
}