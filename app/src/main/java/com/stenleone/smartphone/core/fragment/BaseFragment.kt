package com.stenleone.smartphone.core.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.stenleone.smartphone.core.activity.BaseBindingActivity
import com.stenleone.smartphone.util.ext.hideKeyboard

abstract class BaseFragment : Fragment() {

    protected abstract val layoutId: Int
    val toastManager = (activity as? BaseBindingActivity<*>?)?.toastManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.hideKeyboard()
    }

}