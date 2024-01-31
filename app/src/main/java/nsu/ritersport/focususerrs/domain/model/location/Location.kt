package nsu.ritersport.focususerrs.domain.model.location

data class Location (
    val street: String,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
    val coordinates: Coordinates,
    val timezone: Timezone,


) {
    fun addressString() = "%s, %s, %s, %s".format(country, state, city, street)
}