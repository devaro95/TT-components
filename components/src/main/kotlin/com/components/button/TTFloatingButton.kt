package com.components.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.components.styles.Primary
import com.vro.compose.preview.VROLightMultiDevicePreview

@Composable
fun TTFloatingButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean,
    color: Color,
    onClick: () -> Unit,
) {
    FloatingActionButton(
        onClick = { if (enabled) onClick() },
        shape = RoundedCornerShape(24.dp),
        modifier = modifier.height(50.dp),
        containerColor = if (enabled) color else MaterialTheme.colorScheme.secondaryContainer
    ) {
        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
            Row(horizontalArrangement = Arrangement.Center) {
                Text(
                    text = text,
                    fontSize = 16.sp,
                    color = if (enabled) MaterialTheme.colorScheme.background
                    else MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTFloatingButtonPreview() {
    TTFloatingButton(
        text = "Text",
        enabled = true,
        color = Primary,
        onClick = {},
    )
}