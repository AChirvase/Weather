package com.alex.weather.domain.usecase

import com.alex.weather.domain.repository.WeatherRepository
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {

    suspend operator fun invoke() = repository.getWeatherEvents()
}