package nsu.ritersport.focususerrs.domain.model

enum class Gender {
    MALE,
    FEMALE,
    UNKNOWN;

    companion object {
        fun fromString(str: String): Gender =
            when(str) {
               "male" -> MALE
                "female" -> FEMALE
                else -> UNKNOWN
            }

        fun Gender.asString() = when(this) {
            MALE -> "Male"
            FEMALE -> "Female"
            else -> "Unknown"
        }
    }

}
