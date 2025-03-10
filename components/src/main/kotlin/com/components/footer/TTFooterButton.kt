package com.components.footer

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.app.R
import com.components.button.TTButton
import com.vro.compose.preview.VROLightMultiDevicePreview

@VROLightMultiDevicePreview
@Composable
private fun TTFooterButtonPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        TTFooterButton(
            text = stringResource(id = R.string.button_continue),
            onClick = {}
        )
    }
}

@Composable
fun TTFooterButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: String,
    onClick: () -> Unit,
    paddingHorizontal: Dp = 0.dp,
) {
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.weight(1f))
        TTButton(
            text = text,
            onClick = onClick,
            enabled = enabled,
            modifier = Modifier
                .padding(vertical = 24.dp, horizontal = paddingHorizontal)
                .fillMaxWidth()
        )
    }
}