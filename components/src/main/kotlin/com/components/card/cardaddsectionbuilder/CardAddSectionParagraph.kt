package com.components.card.cardaddsectionbuilder

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.paragraph.TTParagraph
import com.components.section.TTSectionAdd
import com.domain.model.SectionModel
import com.domain.model.SectionModel.ParagraphSection
import com.mock.textLongMock
import com.mock.titleMock

@Composable
fun CreateSectionParagraph(onSectionAddClick: (SectionModel) -> Unit) {
    TTSectionAdd(onSave = { onSectionAddClick.invoke(ParagraphSection.Paragraph()) }) {
        TTParagraph(
            modifier = Modifier.padding(horizontal = 16.dp),
            title = titleMock,
            text = textLongMock
        )
    }
}