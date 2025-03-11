package com.components.button

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.components.icon.TTIcon
import com.components.styles.Background
import com.components.styles.Primary
import com.components.text.TTHeaderText14
import com.ttcomponents.app.R
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING

@Composable
fun TTButtonIconSquare(
    modifier: Modifier = Modifier,
    contentModifier: Modifier = Modifier,
    iconRes: Int,
    onClick: () -> Unit = {},
    text: String = EMPTY_STRING,
    iconPadding: Dp = 8.dp,
    iconSize: Dp = 18.dp,
    backgroundColor: Color = Background,
    contentColor: Color? = null,
) {
    ElevatedCard(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = backgroundColor
        ),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
        onClick = onClick
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = contentModifier.padding(horizontal = 4.dp)
        ) {
            if (text.isNotEmpty()) {
                TTHeaderText14(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .padding(vertical = 8.dp),
                    text = text,
                    color = contentColor ?: Primary
                )
            }
            TTIcon(
                modifier = Modifier.padding(iconPadding),
                iconRes = iconRes,
                size = iconSize,
                onClick = onClick,
                tint = contentColor
            )
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTIconSquarePreview() {
    Column {
        TTButtonIconSquare(
            iconRes = R.drawable.ic_like_empty,
            onClick = {}
        )
        TTButtonIconSquare(
            iconRes = R.drawable.ic_like_empty,
            onClick = {},
            text = "10.3M"
        )
    }
}
