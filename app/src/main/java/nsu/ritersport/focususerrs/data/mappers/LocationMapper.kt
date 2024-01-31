package nsu.ritersport.focususerrs.data.mappers

import nsu.ritersport.focususerrs.data.model.LocationDto
import nsu.ritersport.focususerrs.data.source.models.LocationResponse

object LocationMapper {
    fun toEntity(response: LocationResponse, tzRef: Long) = LocationDto(
        0,
        response.postcode,
        response.country,
        response.state,
        response.city,
        response.street.name,
        response.coordinates.latitude.toFloat(),
        response.coordinates.longitude.toFloat(),
        tzRef
    )
}