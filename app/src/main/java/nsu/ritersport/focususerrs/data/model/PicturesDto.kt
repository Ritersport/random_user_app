package nsu.ritersport.focususerrs.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pictures")
data class PicturesDto(
    @PrimaryKey (autoGenerate = true) val picsId: Int = 0,
    val largePicture: String,
    val mediumPicture: String,
    val thumbnailPicture: String,
)
