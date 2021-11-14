package com.stenleone.smartphone.core.viewModel

import androidx.annotation.StringRes
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.FirebaseTooManyRequestsException
import com.stenleone.smartphone.R
import com.stenleone.smartphone.domain.entity.base.ParsedError
import com.stenleone.smartphone.domain.entity.base.ServerError
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.*
import java.util.concurrent.TimeoutException

open class BaseViewModel : ViewModel() {

    val messageTextData = MutableLiveData<String?>()
    val messageResData = MutableLiveData<Int?>()
    val keyboard = MutableLiveData<Unit>()

    fun showMessage(message: String?) {
        messageTextData.value = message
    }

    fun showMessage(@StringRes messageId: Int) {
        messageResData.value = messageId
    }

    fun hideKeyboard() {
        keyboard.postValue(Unit)
    }

}