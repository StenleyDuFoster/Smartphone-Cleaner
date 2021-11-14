package com.stenleone.smartphone.core.fragment

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.stenleone.smartphone.core.eventState.BaseState
import com.stenleone.smartphone.core.viewModel.BaseStateViewModel

abstract class BaseStateFragment<VM : BaseStateViewModel<*>, B : ViewDataBinding> :
    BaseVMFragment<VM, B>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state.observe(viewLifecycleOwner, {
            it.getContentIfNotHandled()?.let { state ->
                onStateChanged(state)
            }
        })
    }

    protected abstract fun onStateChanged(state: BaseState)
}