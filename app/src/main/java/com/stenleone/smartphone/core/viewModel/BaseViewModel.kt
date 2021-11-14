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

    fun Throwable.parseResponseError(): ParsedError {
        return when (this) {
//            is HttpException -> {
//                if (this.message?.trim() == "HTTP 429" || this.message?.trim() == "HTTP 500") {
//                    ParsedError(errorResId = R.string.http429_msg)
//                } else {
//                    Timber.e(this)
//                    ParsedError(error = this.message)
//                }
//
//            }
            is SocketTimeoutException -> {
                ParsedError(errorResId = R.string.slow_internet)
            }
            is UnknownHostException -> {
                ParsedError(errorResId = R.string.no_internet_connection)

            }
            is TimeoutException -> {
                ParsedError(errorResId = R.string.no_internet_or_slow)
            }
            is ConnectException -> {
                ParsedError(errorResId = R.string.no_internet_connection)
            }
            is FirebaseTooManyRequestsException -> {
                ParsedError(errorResId = R.string.http429_msg)
            }
//            is UndeliverableException -> {
//                if (this.message?.trim()?.contains(
//                        "FirebaseTooManyRequestsException",
//                        true
//                    ) == true
//                ) {
//                    ParsedError(errorResId = R.string.http429_msg)
//                } else {
//                    ParsedError(error = this.message)
//                }
//
//            }
            is FirebaseNetworkException -> {
                ParsedError(errorResId = R.string.no_internet_connection)
            }
            is FirebaseException -> {
                if (this.message == "An internal error has occurred. [ 7: ]") {
                    ParsedError(errorResId = R.string.no_internet_connection)
                } else {
                    ParsedError(error = this.message)
                }
            }
            is RuntimeException -> {
                when (this.message) {
                    "com.google.firebase.FirebaseException: An internal error has occurred. [ 7: ]" -> {
                        ParsedError(errorResId = R.string.no_internet_connection)
                    }
                    "com.google.firebase.FirebaseNetworkException: A network error (such as timeout, interrupted connection or unreachable host) has occurred." -> {
                        ParsedError(errorResId = R.string.no_internet_connection)
                    }
                    else -> {
                        if (this.message?.contains("TimeoutException") == true)
                            ParsedError(errorResId = R.string.no_internet_or_slow)
                        else
                            ParsedError(error = this.message)
                    }
                }
            }


            //Firebase exceptions
            /*this is FirebaseAuthInvalidCredentialsException -> {
                ParsedError(errorResId = R.string.firebase_auth_invalid_credentials_exception)
            }
            this is FirebaseAuthInvalidUserException -> {
                ParsedError(errorResId = R.string.firebase_auth_invalid_user_exception)

            }
            this is ServerException -> {
                this.errors?.parseServerError() ?: ParsedError(error = "")
            }

            this is FirebaseAuthUserCollisionException -> {
                ParsedError(errorResId = R.string.user_exists_error_msg)
            }
            this.message?.contains("FirebaseAuthInvalidUserException") == true -> {
                ParsedError(errorResId = R.string.firebase_auth_invalid_user_exception)

            }
            this.message?.contains("FirebaseNetworkException") == true -> {
                if (this@BaseViewModel !is SplashViewModel)
                    ParsedError(errorResId = R.string.no_internet_connection)
                else {
                    ParsedError(errorResId = R.string.no_internet_connection)
                }
            }*/
            else -> ParsedError(
                error =
                this.message?.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
            )
        }
    }

    fun ServerError.parseServerError(): ParsedError {
        return when (this.id) {
            //"INVALID_PIN" -> ParsedError(errorResId = R.string.invalid_pin_error)
            else -> ParsedError(error = this.message)
        }
    }
}