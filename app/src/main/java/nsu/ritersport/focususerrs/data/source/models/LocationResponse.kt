package nsu.ritersport.focususerrs.data.source.models

data class LocationResponse(
    val street: StreetResponse,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
    val coordinates: CoordinatesResponse,
    val timezone: TimezoneResponse,
)
