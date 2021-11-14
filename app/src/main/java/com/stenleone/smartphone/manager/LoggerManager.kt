package com.stenleone.smartphone.manager

import android.util.Log

object LoggerManager {

    private const val TAG = "DefaultLogger"

    fun v(any: Any?) {
        Log.v(Exception().stackTrace.getOrNull(1)?.toString() ?: TAG, any.toString())
    }

    fun e(any: Any?) {
        Log.e(Exception().stackTrace.getOrNull(1)?.toString() ?: TAG, any.toString())
    }

    fun w(any: Any?) {
        Log.w(Exception().stackTrace.getOrNull(1)?.toString() ?: TAG, any.toString())
    }

}