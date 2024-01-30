package nsu.ritersport.focususerrs.domain.model

import nsu.ritersport.focususerrs.domain.model.location.SimpleLocation

data class SimpleUser(
    val userId: String,
    val name: Name,
    val location: SimpleLocation,
    val phone: String,
    val picture: String,
)
