package com.alex.weather.data.remote.api

import com.alex.weather.domain.WeatherEvent
import dagger.Provides
import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Singleton

interface WeatherApi {

    @GET("/alerts/active?status=actual&message_type=alert")
    suspend fun getAllWeatherEvents(): List<WeatherEventResponse>
}