package com.alex.weather.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow

abstract class BaseViewModel<T : State, in E : Event> : ViewModel() {

    abstract val state: Flow<T>

}