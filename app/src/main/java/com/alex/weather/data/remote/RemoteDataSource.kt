package com.alex.weather.data.remote

import com.alex.weather.data.remote.api.WeatherApi
import com.alex.weather.data.remote.api.WeatherEventResponse
import com.alex.weather.data.remote.utils.NetworkResponseHandler
import com.alex.weather.data.remote.utils.Resource
import com.alex.weather.domain.WeatherEvent
import javax.inject.Inject

interface RemoteDataSource {
    suspend fun getAllWeatherEvents(): List<WeatherEventResponse>
}

class RemoteDataSourceImpl @Inject constructor(
    private val weatherApi: WeatherApi
) :
    RemoteDataSource {

    override suspend fun getAllWeatherEvents(): List<WeatherEventResponse> {
        return weatherApi.getAllWeatherEvents().features.map {
            it.properties
        }
    }
}