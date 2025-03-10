package com.sample

import androidx.navigation.NavController
import com.sample.SampleNavigator.SampleDestinations
import com.vro.compose.VROComposableActivity
import com.vro.compose.VROComposableNavigator
import com.vro.navigation.VRODestination

class SampleNavigator(
    activity: VROComposableActivity,
    navController: NavController,
) : VROComposableNavigator<SampleDestinations>(activity, navController) {

    override fun navigate(destination: SampleDestinations) = Unit

    sealed class SampleDestinations : VRODestination()
}