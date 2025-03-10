package com.components.section

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.guide.guideBuilder.BuildSectionParams
import com.components.paragraph.TTParagraph
import com.domain.model.SectionModel
import com.vro.compose.preview.VROLightMultiDevicePreview

@VROLightMultiDevicePreview
@Composable
private fun TTSectionParagraphPreview() {
    TTSectionParagraph(
        BuildSectionParams(
            sectionModel = SectionModel.ParagraphSection.Paragraph(),
            isEditable = true,
            showButton = true,
            onDeleteSection = {},
            onEditSection = {},
            onCopySection = {}
        )
    )
}

@Composable
fun TTSectionParagraph(params: BuildSectionParams) {
    val sectionModel = params.sectionModel as SectionModel.ParagraphSection
    TTSection(
        modifier = Modifier.padding(horizontal = 16.dp),
        params = params
    ) {
        TTParagraph(
            title = sectionModel.model.title,
            text = sectionModel.model.text
        )
    }
}