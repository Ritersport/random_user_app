package nsu.ritersport.focususerrs.data.model

data class ShortInfoDto(
    val uuid: String,
    val titleName: String,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val thumbnailPicture: String,
    val country: String,
    val state: String,
    val city: String,
    val street: String,
)
