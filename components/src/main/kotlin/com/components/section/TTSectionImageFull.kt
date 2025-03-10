package com.components.section

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.guide.guideBuilder.BuildSectionParams
import com.components.image.TTImageFull
import com.model.SectionModel
import com.model.SectionModel.ImageSection
import com.vro.compose.preview.VROLightMultiDevicePreview

@VROLightMultiDevicePreview
@Composable
private fun TTImageFullPreview() {
    TTSectionImageFull(
        BuildSectionParams(
            sectionModel = SectionModel.ImageSection.ImageFull(),
            isEditable = true,
            showButton = true,
            onDeleteSection = {},
            onEditSection = {},
            onCopySection = {},
        )
    )
}

@Composable
fun TTSectionImageFull(params: BuildSectionParams) {
    val sectionModel = params.sectionModel as ImageSection
    TTSection(
        footerModifier = Modifier.padding(horizontal = 16.dp),
        params = params
    ) {
        TTImageFull(
            image = sectionModel.model.itemList.first(),
            text = sectionModel.model.text
        )
    }
}