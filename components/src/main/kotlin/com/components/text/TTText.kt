package com.components.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.app.R
import com.components.styles.EmptyColor
import com.components.styles.Font
import com.components.styles.GuideCardHeader
import com.components.styles.Placeholder
import com.components.styles.Primary

@Composable
fun TTTitleText16(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        style = MaterialTheme.typography.titleMedium
    )
}

@Composable
fun TTAddressText(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
) {
    Text(
        modifier = modifier,
        text = text,
        color = GuideCardHeader,
        fontSize = 14.sp,
        textAlign = textAlign,
        fontFamily = Font,
    )
}

@Composable
fun TTItalicText(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
) {
    Text(
        modifier = modifier,
        text = text,
        color = Primary,
        fontSize = 16.sp,
        fontStyle = FontStyle.Italic,
        textAlign = textAlign,
        fontFamily = Font,
    )
}

@Composable
fun TTErrorText(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
) {
    Text(
        modifier = modifier,
        text = text,
        color = MaterialTheme.colorScheme.error,
        fontSize = 14.sp,
        textAlign = textAlign,
        style = MaterialTheme.typography.bodySmall,
        fontFamily = FontFamily(Font(R.font.main_font_medium))
    )
}
