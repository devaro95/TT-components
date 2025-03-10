package com.components.divider

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.components.styles.Primary

@Preview
@Composable
fun TTSectionDividerPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        TTSectionDivider()
    }
}

@Composable
fun TTSectionDivider(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            color = Primary,
            thickness = 1.dp
        )
        TTCircle(6.dp)
        TTCircle(10.dp)
        TTCircle(6.dp)
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            color = Primary,
            thickness = 1.dp
        )
    }
}

@Composable
private fun TTCircle(size: Dp) {
    Canvas(
        modifier = Modifier.size(size)
    ) {
        drawCircle(Primary)
        drawCircle(Primary)
    }
}