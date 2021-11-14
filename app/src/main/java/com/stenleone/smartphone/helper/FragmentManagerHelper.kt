package com.stenleone.smartphone.helper

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.stenleone.smartphone.core.fragment.BaseFragment
import com.stenleone.smartphone.manager.LoggerManager
import javax.inject.Inject

class FragmentManagerHelper @Inject constructor() : LifecycleObserver {

    private var fragmentManager: FragmentManager? = null
    private var lifecycle: Lifecycle? = null

    private var containerId: Int? = null

    fun setup(fragmentManager: FragmentManager, lifecycle: Lifecycle, containerId: Int) {
        destroy()
        this.fragmentManager = fragmentManager
        this.lifecycle = lifecycle
        this.containerId = containerId
    }

    fun oneTimeReplace(frag: BaseFragment, containerId: Int? = this.containerId) {
        if (fragmentManager?.findFragmentByTag(getTagFragment(frag)) == null) {
            replace(frag, containerId)
        }
    }

    fun replace(frag: BaseFragment, containerId: Int? = this.containerId) {
        if (containerId != null) {
            fragmentManager?.beginTransaction()?.replace(containerId, frag, getTagFragment(frag))?.commit()
        } else {
            LoggerManager.w("Container id null in FragmentManagerHelper ${this.hashCode()}")
        }
    }

    private fun getTagFragment(frag: BaseFragment) = frag.tag ?: frag.toString()

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun destroy() {
        fragmentManager = null
        lifecycle?.removeObserver(this)
        lifecycle = null
        containerId = null
    }
}