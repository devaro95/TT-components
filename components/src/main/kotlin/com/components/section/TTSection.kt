package com.components.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.components.footer.TTSectionFooter
import com.components.guide.guideBuilder.BuildSectionParams

@Composable
fun TTSection(
    modifier: Modifier = Modifier,
    footerModifier: Modifier = Modifier,
    params: BuildSectionParams,
    content: @Composable () -> Unit,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        content.invoke()
        TTSectionFooter(
            params = params,
            modifier = footerModifier
        )
    }
}