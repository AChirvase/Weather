package com.alex.weather.domain

class WeatherEvent(
    val id: String,
    val event: String?,
    val description: String?,
    val effective: String?,
    val ends: String?,
    val senderName: String?,
    val severity: String?,
    val certainty: String?
)