package com.alex.weather.feature.homefeed

import androidx.lifecycle.viewModelScope
import com.alex.weather.base.BaseViewModel
import com.alex.weather.base.Reducer
import com.alex.weather.base.TimeCapsule
import com.alex.weather.domain.usecase.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFeedViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val dispatcher: CoroutineDispatcher,
    private val viewMapper: HomeFeedViewDataMapper,
) : BaseViewModel<HomeFeedState, HomeFeedEvent>() {

    private val reducer = MainReducer(HomeFeedState.initial())

    override val state: StateFlow<HomeFeedState>
        get() = reducer.state
    init {
        viewModelScope.launch(dispatcher) {
            getWeatherUseCase.invoke().collect { weatherEventList ->
                sendEvent(HomeFeedEvent.ShowData(viewMapper.buildScreen(weatherEventList)))
            }
        }
    }

    private fun sendEvent(event: HomeFeedEvent) {
        reducer.sendEvent(event)
    }

    fun onItemClick(id: String) {
        sendEvent(HomeFeedEvent.OnWeatherEventClicked(id))
    }

    private class MainReducer(initial: HomeFeedState) :
        Reducer<HomeFeedState, HomeFeedEvent>(initial) {
        override fun reduce(oldState: HomeFeedState, event: HomeFeedEvent) {
            when (event) {
                is HomeFeedEvent.ShowData -> {
                    setState(oldState.copy(isLoading = false, data = event.items))
                }
            }
        }
    }
}