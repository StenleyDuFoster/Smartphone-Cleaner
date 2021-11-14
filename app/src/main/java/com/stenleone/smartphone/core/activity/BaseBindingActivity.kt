package com.stenleone.smartphone.core.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.stenleone.smartphone.helper.FragmentManagerHelper
import com.stenleone.smartphone.manager.ToastManager
import javax.inject.Inject

abstract class BaseBindingActivity<Binding : ViewDataBinding> : AppCompatActivity() {

    lateinit var binding: Binding

    protected abstract val layoutId: Int

    protected abstract val fragmentContainerId: Int

    @Inject
    lateinit var toastManager: ToastManager

    @Inject
    protected lateinit var fragmentManagerHelper: FragmentManagerHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutId)
        toastManager.setup(this)
        fragmentManagerHelper.setup(supportFragmentManager, this.lifecycle, fragmentContainerId)
    }
}