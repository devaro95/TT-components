package com.components.section

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.cardcarousel.TTCardCarouselImage
import com.components.guide.guideBuilder.BuildSectionParams
import com.domain.model.GuideModel.ImageModel
import  com.domain.model.ImageSectionModel
import com.domain.model.SectionModel.ImageSection
import com.vro.compose.preview.VROLightMultiDevicePreview

@VROLightMultiDevicePreview
@Composable
private fun TTSectionCardCarouselImagePreview() {
    TTSectionCardCarouselImage(
        params = BuildSectionParams(
            sectionModel = ImageSection.CardCarousel(
                model = ImageSectionModel(itemList = listOf(ImageModel(), ImageModel()))
            ),
            isEditable = true,
            showButton = true,
            onDeleteSection = {},
            onEditSection = {},
            onCopySection = {},
        )
    )
}

@Composable
fun TTSectionCardCarouselImage(
    modifier: Modifier = Modifier,
    params: BuildSectionParams,
) {
    val sectionModel = params.sectionModel as ImageSection
    TTSection(
        modifier = modifier,
        footerModifier = Modifier.padding(horizontal = 16.dp),
        params = params,
    ) {
        TTCardCarouselImage(items = sectionModel.model.itemList, text = sectionModel.model.text)
    }
}