package com.sample

import com.sample.SampleNavigator.SampleDestinations
import com.vro.compose.VROComposableViewModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class SampleViewModel : VROComposableViewModel<SampleState, SampleDestinations, SampleEvents>() {

    override val initialState = SampleState.INITIAL

    override fun onEvent(event: SampleEvents) = Unit
}