package com.components.card.cardaddsectionbuilder

import androidx.compose.runtime.Composable
import com.domain.model.SectionModel
import com.domain.model.SectionModel.SectionType.BULLET
import com.domain.model.SectionModel.SectionType.IMAGE
import com.domain.model.SectionModel.SectionType.INFO
import com.domain.model.SectionModel.SectionType.PARAGRAPH
import com.domain.model.SectionModel.SectionType.RESTAURANT
import com.domain.model.SectionModel.SectionType.ROUTE

@Composable
fun BuildSectionCard(
    sectionType: SectionModel.SectionType,
    onSectionAddClick: (SectionModel) -> Unit,
) {
    when (sectionType) {
        PARAGRAPH -> CreateSectionParagraph(onSectionAddClick)
        RESTAURANT -> CreateSectionRestaurant(onSectionAddClick)
        BULLET -> CreateSectionBullet(onSectionAddClick)
        IMAGE -> CreateSectionImage(onSectionAddClick)
        INFO -> CreateSectionInfo(onSectionAddClick)
        ROUTE -> CreateSectionRoute(onSectionAddClick)
    }
}