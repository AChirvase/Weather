package com.alex.weather.data.local.di

import com.alex.weather.data.local.LocalDataSource
import com.alex.weather.data.local.LocalDataSourceImpl
import com.alex.weather.data.local.room.WeatherEventDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class LocalDataSourceModule {

    @Provides
    fun provideLocalDataSource(weatherEventDao: WeatherEventDao): LocalDataSource {
        return LocalDataSourceImpl(weatherEventDao)
    }
}