package com.components.card

import androidx.compose.runtime.Composable
import com.components.card.cardaddsectionbuilder.BuildSectionCard
import com.model.SectionModel
import com.model.SectionModel.SectionType

@Composable
fun TTCardAddSectionList(
    sectionType: SectionType,
    onSectionAddClick: (SectionModel) -> Unit,
) {
    BuildSectionCard(
        sectionType = sectionType,
        onSectionAddClick = onSectionAddClick
    )
}