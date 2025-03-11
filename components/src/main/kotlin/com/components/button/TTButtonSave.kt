package com.components.button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ttcomponents.app.R
import com.components.styles.Secondary
import com.components.styles.White
import com.vro.compose.preview.VROLightMultiDevicePreview

@Composable
fun TTButtonSave(onClick: () -> Unit) {
    Column(modifier = Modifier.padding(start = 6.dp)) {
        TTButtonIconSquare(
            iconRes = R.drawable.ic_save_section,
            onClick = onClick,
            backgroundColor = Secondary,
            contentColor = White
        )
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTButtonSavePreview() {
    TTButtonSave(onClick = {})
}