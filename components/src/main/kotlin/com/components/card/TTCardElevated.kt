package com.components.card

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.components.styles.CardBackground
import com.vro.compose.preview.VROLightMultiDevicePreview

@Composable
fun TTCardElevated(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    background: Color = CardBackground,
    content: @Composable ColumnScope.() -> Unit
) {
    ElevatedCard(
        modifier = modifier,
        colors = CardDefaults.elevatedCardColors(
            containerColor = background,
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 6.dp
        ),
        shape = RoundedCornerShape(10.dp),
        onClick = onClick,
    ) {
        content.invoke(this)
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTCardElevatedPreview() {
    TTCardElevated(content = {})
}