package com.stenleone.smartphone.core.eventState

import com.stenleone.smartphone.domain.entity.base.ParsedError

open class DefaultState : BaseState {
    object Loading : DefaultState()
    class Error(error: ParsedError)
    class Success<T>(data: T)
}
