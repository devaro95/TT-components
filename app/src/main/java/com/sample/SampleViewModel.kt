package com.sample

import com.ComponentType
import com.sample.SampleEvents.Detail
import com.sample.SampleNavigator.SampleDestinations
import com.sample.SampleNavigator.SampleDestinations.DetailDestination
import com.vro.compose.VROComposableViewModel
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class SampleViewModel : VROComposableViewModel<SampleState, SampleDestinations, SampleEvents>() {

    override val initialState = SampleState.INITIAL

    override fun onEvent(event: SampleEvents) {
        when (event) {
            is Detail -> onDetailClick(event.componentType)
        }
    }

    private fun onDetailClick(componentType: ComponentType) {
        navigate(DetailDestination(componentType))
    }
}