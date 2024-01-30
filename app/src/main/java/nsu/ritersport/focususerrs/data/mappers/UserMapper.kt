package nsu.ritersport.focususerrs.data.mappers

import android.annotation.SuppressLint
import android.os.Build
import android.text.format.DateUtils
import androidx.annotation.RequiresApi
import nsu.ritersport.focususerrs.data.model.FullInfoDto
import nsu.ritersport.focususerrs.data.model.ShortInfoDto
import nsu.ritersport.focususerrs.data.model.UserDto
import nsu.ritersport.focususerrs.data.source.models.UserResponse
import nsu.ritersport.focususerrs.domain.model.Gender
import nsu.ritersport.focususerrs.domain.model.Name
import nsu.ritersport.focususerrs.domain.model.SimpleUser
import nsu.ritersport.focususerrs.domain.model.User
import nsu.ritersport.focususerrs.domain.model.location.Coordinates
import nsu.ritersport.focususerrs.domain.model.location.Location
import nsu.ritersport.focususerrs.domain.model.location.SimpleLocation
import nsu.ritersport.focususerrs.domain.model.location.Timezone
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.temporal.ChronoUnit

object UserMapper {
    fun shortToDomain(userDto: ShortInfoDto) = SimpleUser(
        userDto.uuid,
        Name(userDto.titleName, userDto.firstName, userDto.lastName),
        SimpleLocation(userDto.street, userDto.city, userDto.state, userDto.country),
        userDto.phone,
        userDto.thumbnailPicture
    )

    @SuppressLint("NewApi")
    fun fullToDomain(userDto: FullInfoDto) = User(
        userDto.uuid,
        Gender.fromString(userDto.gender),
        Name(userDto.titleName, userDto.firstName, userDto.lastName),
        Location(
            userDto.street,
            userDto.city,
            userDto.state,
            userDto.country,
            userDto.postcode,
            Coordinates(userDto.latitude, userDto.longitude),
            Timezone(userDto.offset, userDto.description)
        ),
        userDto.email,
        getAge(Instant.parse(userDto.birthdate)),
        getAge(Instant.parse(userDto.registrationDate)),
        userDto.phone,
        userDto.largePicture
    )

    fun toEntity(response: UserResponse, locationRef: Int, picRef: Int) = UserDto(
        response.login.uuid,
        response.name.title,
        response.name.first,
        response.name.last,
        response.gender,
        response.email,
        response.phone,
        response.cell,
        response.dob.date,
        response.registered.date,
        locationRef,
        picRef
    )

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getAge(birthday: Instant): Int {
        val bdLocalDateTime = LocalDateTime.ofInstant(birthday, ZoneId.systemDefault())
        val today = LocalDateTime.now()
        return ChronoUnit.YEARS.between(bdLocalDateTime, today).toInt()
    }
}