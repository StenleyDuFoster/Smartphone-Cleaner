package com.stenleone.smartphone.manager.preferences.core

import android.content.Context
import com.stenleone.smartphone.manager.LoggerManager
import com.stenleone.smartphone.util.constant.MonetizationEnum
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CorePreferencesManager @Inject constructor(@ApplicationContext private val context: Context) {

    private val sharedPreferences by lazy { context.getSharedPreferences(CorePreferencesEnum.NAME.value, Context.MODE_PRIVATE) }

    var monetizationType: Int
        get() = sharedPreferences.getInt(CorePreferencesEnum.MONETIZATION_TYPE.value, MonetizationEnum.UNSELECTED.value)
        set(value) {
            var isValid = false

            MonetizationEnum.values().forEach {
                if (value == it.value) {
                    isValid = true
                }
            }

            if (isValid) {
                sharedPreferences.edit().putInt(CorePreferencesEnum.MONETIZATION_TYPE.value, value)
            } else {
                LoggerManager.w("Not valid value Monetization")
            }
        }

}