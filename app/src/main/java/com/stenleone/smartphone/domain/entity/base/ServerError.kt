package com.stenleone.smartphone.domain.entity.base

data class ServerError(
    val id: String = "",
    val message: String = ""
) {
    fun parseServerError(): ParsedError {
        return when (this.id) {
            //"INVALID_PIN" -> ParsedError(errorResId = R.string.invalid_pin_error)
            else -> ParsedError(error = this.message)
        }
    }
}