package com.components.stepper

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.components.styles.Primary
import com.components.styles.Secondary
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.INT_ZERO

@Composable
fun TTStepper(
    modifier: Modifier = Modifier,
    items: Int = 2,
    currentItem: Int = INT_ZERO,
) {
    Row(
        modifier
            .fillMaxWidth()
            .height(10.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        repeat(items) {
            Spacer(
                Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .clip(RoundedCornerShape(4.dp))
                    .border(1.dp, Primary, RoundedCornerShape(10.dp))
                    .alpha(
                        if (it < currentItem) 0.5f
                        else 1f
                    )
                    .background(
                        if (it <= currentItem) Secondary
                        else Color.Transparent
                    )
            )
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTStepperPreview() {
    TTStepper(
        items = 3,
        currentItem = 1
    )
}