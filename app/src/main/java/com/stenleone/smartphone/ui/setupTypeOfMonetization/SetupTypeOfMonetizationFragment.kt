package com.stenleone.smartphone.ui.setupTypeOfMonetization

import androidx.fragment.app.viewModels
import com.stenleone.smartphone.R
import com.stenleone.smartphone.core.eventState.BaseState
import com.stenleone.smartphone.core.eventState.DefaultState
import com.stenleone.smartphone.core.fragment.BaseStateFragment
import com.stenleone.smartphone.databinding.FragmentSetupMotetizationTypeBinding

class SetupTypeOfMonetizationFragment : BaseStateFragment<SetupTypeMonetizationViewModel, FragmentSetupMotetizationTypeBinding>() {

    override val layoutId: Int = R.layout.fragment_setup_motetization_type

    override val viewModel: SetupTypeMonetizationViewModel by viewModels()

    override fun onStateChanged(state: BaseState) {

    }

    sealed class State : DefaultState()

}