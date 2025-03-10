package com.components.header

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.components.text.TTBodyText
import com.components.text.TTHeaderText24
import com.mock.textLongMock
import com.mock.titleMock
import com.vro.compose.preview.VROLightMultiDevicePreview

@VROLightMultiDevicePreview
@Composable
private fun TTHeaderPreview() {
    TTHeader(
        title = titleMock,
        description = textLongMock
    )
}

@Composable
fun TTHeader(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
) {
    Column(modifier = modifier.padding(horizontal = 16.dp)) {
        TTHeaderText24(
            modifier = Modifier.fillMaxWidth(),
            text = title,
            textAlign = TextAlign.Center
        )
        TTBodyText(
            modifier = Modifier.padding(top = 16.dp),
            text = description
        )
    }
}