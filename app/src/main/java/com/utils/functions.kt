package com.utils

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.components.styles.Primary

@Composable
fun SectionFirst(
    title: String,
    section: @Composable () -> Unit
) {
    Text(
        modifier = Modifier.padding(top = 8.dp),
        text = title,
        color = Primary,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    )
    section()
}

@Composable
fun Section(
    title: String,
    section: @Composable () -> Unit
) {
    Text(
        modifier = Modifier.padding(top = 24.dp),
        text = title,
        color = Primary,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    )
    section()
}

@Composable
fun TitleText(text: String) {
    Text(
        modifier = Modifier.padding(top = 24.dp),
        text = text,
        color = Primary,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    )
}