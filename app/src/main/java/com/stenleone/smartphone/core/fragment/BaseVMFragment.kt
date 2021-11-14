package com.stenleone.smartphone.core.fragment

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.stenleone.smartphone.core.viewModel.BaseViewModel
import com.stenleone.smartphone.domain.entity.base.ParsedError
import kotlin.reflect.KClass

abstract class BaseVMFragment<VM : BaseViewModel, B : ViewDataBinding> :
    BaseBindingFragment<B>() {

    protected abstract val viewModel: VM

    private val messageObserver = Observer<String?> { toastManager?.showMessage(it) }
    private val messageResObserver = Observer<Int?> { toastManager?.showMessage(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.messageTextData.observe(this, messageObserver)
        viewModel.messageResData.observe(this, messageResObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = this.viewLifecycleOwner
//        binding.setVariable(BR.viewModel, viewModel)
    }

    fun ParsedError.showErrorToast() {
        this.errorResId?.let {
            toastManager?.showMessage(it)
        }
        this.error?.let {
            toastManager?.showMessage(it)
        }
    }
}