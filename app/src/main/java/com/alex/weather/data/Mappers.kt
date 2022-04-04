package com.alex.weather.data

import com.alex.weather.data.local.room.WeatherEventEntity
import com.alex.weather.data.remote.api.WeatherEventResponse
import com.alex.weather.domain.WeatherEvent

fun WeatherEvent.toEntity(): WeatherEventEntity {
    return WeatherEventEntity(
        id = id,
        event = event,
        description = description
    )
}

fun WeatherEventResponse.toEntity(): WeatherEventEntity {
    return WeatherEventEntity(
        id = id,
        event = event,
        description = description
    )
}