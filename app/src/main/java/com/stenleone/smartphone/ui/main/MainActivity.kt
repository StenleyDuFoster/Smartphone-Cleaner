package com.stenleone.smartphone.ui.main

import com.stenleone.smartphone.R
import com.stenleone.smartphone.core.activity.BaseBindingActivity
import com.stenleone.smartphone.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseBindingActivity<ActivityMainBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_main


}