package com.stenleone.smartphone.ui.main

import android.os.Bundle
import com.stenleone.smartphone.R
import com.stenleone.smartphone.core.activity.BaseBindingActivity
import com.stenleone.smartphone.databinding.ActivityMainBinding
import com.stenleone.smartphone.manager.preferences.core.CorePreferencesManager
import com.stenleone.smartphone.ui.setupTypeOfMonetization.SetupTypeOfMonetizationFragment
import com.stenleone.smartphone.util.constant.MonetizationEnum
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseBindingActivity<ActivityMainBinding>() {

    @Inject
    lateinit var corePrefs: CorePreferencesManager

    override val layoutId: Int = R.layout.activity_main

    override val fragmentContainerId: Int = R.id.fragmentContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setup()
    }

    private fun setup() {
        when (corePrefs.monetizationType) {
            MonetizationEnum.UNSELECTED.value -> {
                fragmentManagerHelper.oneTimeReplace(SetupTypeOfMonetizationFragment())
            }
        }
    }
}