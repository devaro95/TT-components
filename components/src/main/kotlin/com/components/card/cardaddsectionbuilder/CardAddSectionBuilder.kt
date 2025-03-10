package com.components.card.cardaddsectionbuilder

import androidx.compose.runtime.Composable
import com.model.SectionModel
import com.model.SectionModel.SectionType.BULLET
import com.model.SectionModel.SectionType.IMAGE
import com.model.SectionModel.SectionType.INFO
import com.model.SectionModel.SectionType.PARAGRAPH
import com.model.SectionModel.SectionType.RESTAURANT
import com.model.SectionModel.SectionType.ROUTE

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