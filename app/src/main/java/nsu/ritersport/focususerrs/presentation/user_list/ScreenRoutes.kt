package nsu.ritersport.focususerrs.presentation.user_list

sealed class ScreenRoutes {
    class ToUser(val userId: String): ScreenRoutes()
}