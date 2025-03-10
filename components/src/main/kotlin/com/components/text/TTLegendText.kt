package com.components.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import com.app.R
import com.components.styles.InputLegend

@Composable
fun TTLegendText(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
) {
    Text(
        modifier = modifier,
        text = text,
        maxLines = 1,
        textAlign = textAlign,
        style = MaterialTheme.typography.bodySmall,
        fontFamily = FontFamily(Font(R.font.main_font_medium)),
        color = InputLegend
    )
}