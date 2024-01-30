package nsu.ritersport.focususerrs.data.model

data class FullInfoDto(
    val uuid: String,
    val titleName: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val email: String,
    val phone: String,
    val cell: String,
    val birthdate: String,
    val registrationDate: String,
    val largePicture: String,
    val postcode: String,
    val country: String,
    val state: String,
    val city: String,
    val street: String,
    val latitude: Float,
    val longitude: Float,
    val offset: String = "",
    val description: String,
)
