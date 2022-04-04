package com.alex.weather.data.di

import com.alex.weather.data.WeatherRepositoryImpl
import com.alex.weather.data.local.LocalDataSource
import com.alex.weather.data.local.LocalDataSourceImpl
import com.alex.weather.data.local.room.WeatherEventDao
import com.alex.weather.data.remote.RemoteDataSource
import com.alex.weather.data.remote.utils.NetworkResponseHandler
import com.alex.weather.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class WeatherRepositoryModule {

    @Provides
    fun provideWeatherRepository(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ): WeatherRepository {
        return WeatherRepositoryImpl(
            localDataSource,
            remoteDataSource
        )
    }
}