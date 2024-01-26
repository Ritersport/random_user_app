package nsu.ritersport.focususerrs.data.source.models

data class LocationResponse(
    val street: StreetResponse,
    val city: String,
    val state: String,
    val country: String,
    val postcode: Int,
    val coordinates: CoordinatesResponse,
    val timezone: TimezoneResponse,
)
