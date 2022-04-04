package com.alex.weather.data

import com.alex.weather.data.local.LocalDataSource
import com.alex.weather.data.local.toDomain
import com.alex.weather.data.remote.RemoteDataSource
import com.alex.weather.data.remote.toDomain
import com.alex.weather.data.remote.utils.NetworkResponseHandler
import com.alex.weather.data.remote.utils.Resource
import com.alex.weather.domain.WeatherEvent
import com.alex.weather.domain.repository.WeatherRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : WeatherRepository {

    override suspend fun getWeatherEvents(): Flow<List<WeatherEvent>> {
        return localDataSource.getAllWeatherEvents().map { weatherEventEntityList ->
            weatherEventEntityList.map { it.toDomain() }
        }.also {
            remoteDataSource.getAllWeatherEvents()
                .map { it.toEntity() }
                .also { localDataSource.addAllWeatherEvent(it) }
        }
    }
}