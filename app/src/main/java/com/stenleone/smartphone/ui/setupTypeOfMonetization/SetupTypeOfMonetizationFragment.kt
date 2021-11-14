package com.stenleone.smartphone.ui.setupTypeOfMonetization

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.stenleone.smartphone.R
import com.stenleone.smartphone.core.eventState.BaseState
import com.stenleone.smartphone.core.eventState.DefaultState
import com.stenleone.smartphone.core.fragment.BaseStateFragment
import com.stenleone.smartphone.databinding.FragmentSetupMotetizationTypeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SetupTypeOfMonetizationFragment : BaseStateFragment<SetupTypeMonetizationViewModel, FragmentSetupMotetizationTypeBinding>() {

    override val layoutId: Int = R.layout.fragment_setup_motetization_type

    override val viewModel: SetupTypeMonetizationViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onStateChanged(state: BaseState) {

    }

    sealed class State : DefaultState()

}