package com.components.card.cardaddsectionbuilder

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.info.TTInfoMessage
import com.components.info.TTInfoMessageType
import com.components.section.TTSectionAdd
import com.model.SectionModel
import com.model.SectionModel.InfoSection.InfoBox
import com.model.SectionModel.InfoSection.InfoCard
import com.mock.textMock
import com.mock.titleMock

@Composable
fun CreateSectionInfo(onSectionAddClick: (SectionModel) -> Unit) {
    TTSectionAdd(onSave = { onSectionAddClick.invoke(InfoCard()) }) {
        TTInfoMessage(
            modifier = Modifier.padding(horizontal = 16.dp),
            title = titleMock,
            message = textMock,
            type = TTInfoMessageType.ELEVATED
        )
    }
    TTSectionAdd(onSave = { onSectionAddClick.invoke(InfoBox()) }) {
        TTInfoMessage(
            modifier = Modifier.padding(horizontal = 16.dp),
            title = titleMock,
            message = textMock,
            type = TTInfoMessageType.BORDER
        )
    }
}