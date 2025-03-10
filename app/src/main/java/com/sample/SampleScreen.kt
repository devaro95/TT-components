package com.sample

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.app.R
import com.components.icon.TTIcon
import com.vro.compose.screen.VROScreen

class SampleScreen : VROScreen<SampleState, SampleEvents>() {

    @Composable
    override fun ScreenContent(state: SampleState) {
        Column {
            TTIcon(iconRes = R.drawable.ic_cross)
        }
    }

    @Composable
    override fun ScreenPreview() {
        ScreenContent(SampleState.INITIAL)
    }
}