package com.stenleone.smartphone.manager

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.stenleone.smartphone.R
import com.stenleone.smartphone.core.activity.BaseBindingActivity
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ToastManager @Inject constructor(@ApplicationContext private val context: Context) : LifecycleObserver {

    private var toast: Toast? = null
    private var activity: AppCompatActivity? = null

    fun setup(activity: BaseBindingActivity<*>) {
        this.activity = activity
        activity.lifecycle.addObserver(this)
    }

    fun showMessage(@StringRes messageId: Int?) {
        messageId?.let { showMessage(context.getString(messageId)) }
    }

    fun showMessage(message: String?) {
        if (message.isNullOrBlank()) {
            return
        }
        toast?.cancel()
        toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
        toast?.show()
    }

    fun Any.showErrorToast() {
        when (this) {
            is Int -> {
                showMessage(this)
            }

            is String -> {
                showMessage(this)
            }

            else -> {
                showMessage(context.getString(R.string.unknown_error))
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun destroy() {
        toast?.cancel()
        toast = null
        activity?.lifecycle?.removeObserver(this)
        activity = null
    }

}