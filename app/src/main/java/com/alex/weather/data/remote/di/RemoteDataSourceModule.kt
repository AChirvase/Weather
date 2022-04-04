package com.alex.weather.data.remote.di

import com.alex.weather.data.remote.RemoteDataSource
import com.alex.weather.data.remote.RemoteDataSourceImpl
import com.alex.weather.data.remote.api.WeatherApi
import com.alex.weather.data.remote.utils.NetworkResponseHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
class RemoteDataSourceModule {

    @Provides
    fun provideRemoteDataSource(apiService: WeatherApi): RemoteDataSource {
        return RemoteDataSourceImpl(apiService)
    }
}