package com.components.guide.guideBuilder

import androidx.compose.runtime.Composable
import com.components.info.TTInfoMessageType.BORDER
import com.components.info.TTInfoMessageType.ELEVATED
import com.components.section.TTSectionInfoMessage
import com.domain.model.SectionModel
import com.domain.model.SectionModel.InfoSection.InfoBox
import com.domain.model.SectionModel.InfoSection.InfoCard

@Composable
fun BuildInfoSection(params: BuildSectionParams) {
    val sectionModel = params.sectionModel as SectionModel.InfoSection
    when (sectionModel) {
        is InfoBox -> TTSectionInfoMessage(params = params, type = BORDER)
        is InfoCard -> TTSectionInfoMessage(params = params, type = ELEVATED)
    }
}