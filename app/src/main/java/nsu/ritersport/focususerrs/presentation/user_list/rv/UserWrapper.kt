package nsu.ritersport.focususerrs.presentation.user_list.rv

import android.net.Uri
import nsu.ritersport.focususerrs.domain.model.User

data class UserWrapper (
    val user: User,
    val name: String,
    val address: String,
    val phoneNumber: String,
    val photo: Uri,
)