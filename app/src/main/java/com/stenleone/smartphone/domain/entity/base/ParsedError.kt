package com.stenleone.smartphone.domain.entity.base

import androidx.annotation.StringRes

data class ParsedError(
    @StringRes val errorResId: Int? = null,
    val error: String? = null
)