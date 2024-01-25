package nsu.ritersport.focususerrs.domain.model

import nsu.ritersport.focususerrs.domain.model.location.Location

data class User (
    val gender: Gender,
    val name: Name,
    val location: Location,
    val email: String,
    val age: Int,
    val registered: Int,
    val phone: String,
    val picture: Picture,
)