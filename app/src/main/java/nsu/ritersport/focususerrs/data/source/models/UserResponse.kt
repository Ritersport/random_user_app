package nsu.ritersport.focususerrs.data.source.models

data class UserResponse(
    val gender: String,
    val name: NameResponse,
    val location: LocationResponse,
    val email: String,
    val dob: DateResponse,
    val registered: DateResponse,
    val phone: String,
    val cell: String,
    val picture: PictureResponse
)
