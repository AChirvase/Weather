package com.alex.weather.feature.homefeed

import com.alex.weather.base.Event
import com.alex.weather.base.State
import com.alex.weather.domain.WeatherEvent
import javax.annotation.concurrent.Immutable

@Immutable
sealed class HomeFeedEvent : Event {
    data class ShowData(val items: List<HomeFeedItem>) : HomeFeedEvent()
    data class OnWeatherEventClicked(val id: String) : HomeFeedEvent()
}

@Immutable
data class HomeFeedState(
    val isLoading: Boolean,
    val data: List<HomeFeedItem>
) : State {

    companion object {
        fun initial() = HomeFeedState(
            isLoading = true,
            data = emptyList()
        )
    }
}