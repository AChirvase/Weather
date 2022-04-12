package com.alex.weather.data.remote.api

class WeatherEventListResponse(
    val features: List<WeatherEventPropertiesResponse>
)

class WeatherEventPropertiesResponse(
    val properties: WeatherEventResponse
)

class WeatherEventResponse(
    val id: String,
    val event: String?,
    val description: String?,
    val effective: String?,
    val ends: String?,
    val senderName: String?,
    val severity: String?,
    val certainty: String?
    )

class AffectedZoneResponse(
    val radarStation: Boolean?
)