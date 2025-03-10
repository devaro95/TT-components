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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TTButtonText(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    buttonType: ButtonType = ButtonType.NORMAL,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier.height(buttonType.height),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        shape = CircleShape.copy(CornerSize(24.dp)),
        enabled = enabled
    ) {
        Text(
            text = text,
            fontSize = buttonType.fontSize,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
@Preview
private fun TTButtonTextPreview() {
    TTButtonText(text = "Example") {}
}