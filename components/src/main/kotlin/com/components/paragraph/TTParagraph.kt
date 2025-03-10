package com.components.paragraph

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.text.TTBodyText
import com.components.text.TTHeaderText18
import com.mock.textLongMock
import com.mock.titleMock
import com.vro.compose.preview.VROLightMultiDevicePreview

@VROLightMultiDevicePreview
@Composable
private fun TTParagraphPreview() {
    TTParagraph(
        title = titleMock,
        text = textLongMock
    )
}

@Composable
fun TTParagraph(
    modifier: Modifier = Modifier,
    title: String,
    text: String,
) {
    Column(modifier = modifier) {
        TTHeaderText18(text = title)
        TTBodyText(
            modifier = Modifier.padding(top = 4.dp),
            text = text
        )
    }
}