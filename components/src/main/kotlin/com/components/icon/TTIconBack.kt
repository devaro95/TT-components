package com.components.icon

import androidx.compose.runtime.Composable
import com.app.R
import com.vro.compose.preview.VROLightMultiDevicePreview

@VROLightMultiDevicePreview
@Composable
private fun TTIconBackPreview() {
    TTIconBack {}
}

@Composable
fun TTIconBack(onClick: () -> Unit) {
    TTIcon(
        iconRes = R.drawable.ic_back,
        onClick = onClick
    )
}