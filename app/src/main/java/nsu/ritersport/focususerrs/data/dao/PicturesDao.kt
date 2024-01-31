package nsu.ritersport.focususerrs.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import nsu.ritersport.focususerrs.data.model.PicturesDto

@Dao
interface PicturesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPicture(picturesDto: PicturesDto): Long

    @Query("DELETE FROM pictures")
    fun deletePictures()
}