package com.components.text

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ttcomponents.app.R
import com.components.icon.TTIcon
import com.components.styles.Primary
import com.components.styles.White
import com.vro.constants.EMPTY_STRING

@Composable
fun TTTextBorderIcon(
    modifier: Modifier = Modifier,
    label: String = EMPTY_STRING,
    text: String,
    icon: Int,
    iconSize: Dp = 16.dp,
) {
    Card(
        modifier = modifier,
        border = BorderStroke(1.dp, Primary),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            focusedElevation = 0.dp,
            hoveredElevation = 0.dp,
            draggedElevation = 0.dp,
            disabledElevation = 0.dp,
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = 10.dp,
                vertical = 8.dp
            )
        ) {
            Column {
                if (label.isNotEmpty()) {
                    TTBodyText(
                        text = label,
                        modifier = Modifier.padding(end = 4.dp)
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    TTBodyText(
                        text = text,
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    TTIcon(
                        iconRes = icon,
                        size = iconSize
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun TTTextBorderIconPreview() {
    Column {
        TTTextBorderIcon(
            label = "label",
            text = "Label Test",
            icon = R.drawable.ic_euro
        )
        Spacer(Modifier.height(8.dp))
        TTTextBorderIcon(
            text = "Test",
            icon = R.drawable.ic_euro
        )
    }
}