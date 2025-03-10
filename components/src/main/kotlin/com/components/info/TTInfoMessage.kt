package com.components.info

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.info.TTInfoMessageType.BORDER
import com.components.info.TTInfoMessageType.ELEVATED
import com.components.styles.Primary
import com.components.styles.White
import com.components.text.TTBodyText
import com.components.text.TTHeaderText18
import com.vro.compose.preview.VROLightMultiDevicePreview

@Composable
fun TTInfoMessage(
    modifier: Modifier = Modifier,
    title: String,
    message: String,
    type: TTInfoMessageType,
) {
    Column(modifier = modifier) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(160.dp),
            border = getCardBorder(type),
            elevation = getCardElevation(type),
            colors = CardDefaults.cardColors(
                containerColor = White
            )
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                TTHeaderText18(text = title)
                TTBodyText(
                    modifier = Modifier.padding(top = 8.dp),
                    text = message
                )
            }
        }
    }
}

enum class TTInfoMessageType {
    BORDER, ELEVATED
}

private fun getCardBorder(type: TTInfoMessageType): BorderStroke? {
    return when (type) {
        BORDER -> BorderStroke(1.dp, Primary)
        ELEVATED -> null
    }
}

@Composable
private fun getCardElevation(type: TTInfoMessageType): CardElevation {
    return when (type) {
        BORDER -> {
            CardDefaults.cardElevation(
                defaultElevation = 0.dp,
                pressedElevation = 0.dp,
                focusedElevation = 0.dp,
                hoveredElevation = 0.dp,
                draggedElevation = 0.dp,
                disabledElevation = 0.dp,
            )
        }

        ELEVATED -> CardDefaults.cardElevation(
            defaultElevation = 6.dp,
        )
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTInfoMessagePreview() {
    TTInfoMessage(
        title = "This is a title",
        message = "This is a message",
        type = ELEVATED
    )
}