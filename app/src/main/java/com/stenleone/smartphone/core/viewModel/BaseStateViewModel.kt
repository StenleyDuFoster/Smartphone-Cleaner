package com.stenleone.smartphone.core.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.stenleone.smartphone.core.eventState.BaseState
import com.stenleone.smartphone.core.eventState.Event

open class BaseStateViewModel<State : BaseState> : BaseViewModel() {
    protected val _state = MutableLiveData<Event<State>>()
    val state: LiveData<Event<State>> = _state
}