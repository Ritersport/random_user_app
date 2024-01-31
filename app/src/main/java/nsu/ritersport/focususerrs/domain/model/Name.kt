package nsu.ritersport.focususerrs.domain.model

data class Name(
    val title: String,
    val first: String,
    val last: String,


) {
    override fun toString() = "%s %s %s".format(title, first, last)
}
