package com.components.section

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.guide.guideBuilder.BuildSectionParams
import com.components.info.TTInfoMessage
import com.components.info.TTInfoMessageType
import com.components.info.TTInfoMessageType.ELEVATED
import com.domain.model.SectionModel
import com.vro.compose.preview.VROLightMultiDevicePreview

@VROLightMultiDevicePreview
@Composable
private fun TTSectionInfoMessagePreview() {
    TTSectionInfoMessage(
        type = ELEVATED,
        params = BuildSectionParams(
            isEditable = true,
            showButton = true,
            onDeleteSection = {},
            onEditSection = {},
            onCopySection = {},
            sectionModel = SectionModel.InfoSection.InfoBox(),
        )
    )
}

@Composable
fun TTSectionInfoMessage(
    params: BuildSectionParams,
    type: TTInfoMessageType,
) {
    val sectionModel = params.sectionModel as SectionModel.InfoSection
    TTSection(
        modifier = Modifier.padding(horizontal = 16.dp),
        params = params,
    ) {
        TTInfoMessage(
            title = sectionModel.model.title,
            message = sectionModel.model.text,
            type = type
        )
    }
}