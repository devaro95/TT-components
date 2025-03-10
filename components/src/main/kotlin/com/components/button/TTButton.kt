package com.components.button

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.components.styles.DisabledText
import com.components.styles.Secondary

@Composable
fun TTButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    buttonType: ButtonType = ButtonType.NORMAL,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(buttonType.height),
        colors = ButtonDefaults.buttonColors(
            containerColor = Secondary,
            disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        shape = CircleShape.copy(CornerSize(24.dp)),
        enabled = enabled
    ) {
        Text(
            text = text,
            fontSize = buttonType.fontSize,
            color = if (enabled) MaterialTheme.colorScheme.secondary
            else DisabledText,
            modifier = Modifier.alpha(if (enabled) 1f else 0.5f)
        )
    }
}

enum class ButtonType(
    val height: Dp,
    val fontSize: TextUnit,
) {
    EXTRA_SMALL(
        height = 35.dp,
        fontSize = 12.sp
    ),
    SMALL(
        height = 41.dp,
        fontSize = 14.sp
    ),
    NORMAL(
        height = 51.dp,
        fontSize = 16.sp
    )
}

@Composable
@Preview
private fun TTButtonPreview() {
    TTButton(text = "Example") {}
}