package com.components.icon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ttcomponents.app.R
import com.components.styles.Background
import com.components.styles.Primary
import com.components.text.TTHeaderText14
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING

@Composable
fun TTIconRounded(
    modifier: Modifier = Modifier,
    iconRes: Int,
    onClick: () -> Unit = {},
    text: String = EMPTY_STRING,
    iconPadding: Dp = 8.dp,
    iconSize: Dp = 18.dp,
    backgroundColor: Color = Background,
    iconTint: Color? = null
) {
    ElevatedCard(
        modifier = modifier,
        shape = CircleShape,
        colors = CardDefaults.elevatedCardColors(
            containerColor = backgroundColor
        ),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (text.isNotEmpty()) {
                TTHeaderText14(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .padding(vertical = 8.dp),
                    text = text
                )
            }
            TTIcon(
                modifier = Modifier.padding(iconPadding),
                iconRes = iconRes,
                size = iconSize,
                onClick = onClick,
                tint = iconTint
            )
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTIconRoundedPreview() {
    Column {
        TTIconRounded(
            iconRes = R.drawable.ic_like_empty,
            onClick = {}
        )
        TTIconRounded(
            iconRes = R.drawable.ic_like_empty,
            onClick = {},
            text = "10.3M"
        )
    }
}
