package com.alex.weather.feature.homefeed

import com.alex.weather.domain.WeatherEvent
import javax.inject.Inject

class HomeFeedViewDataMapper @Inject constructor() {

    fun buildScreen(weatherEvents: List<WeatherEvent>): List<HomeFeedItem> {
        val viewData = mutableListOf<HomeFeedItem>()
        viewData.addAll(
            weatherEvents.map {
                HomeFeedItem.EventWeatherItem(
                    id = it.id,
                    event = it.event,
                    description = it.description,
                    effective = it.effective,
                    ends = it.ends,
                    senderName = it.senderName
                )
            })
        return viewData
    }
}