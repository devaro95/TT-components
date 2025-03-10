package com.components.guide.guideBuilder

import androidx.compose.runtime.Composable
import com.components.section.TTSectionCardCarouselImage
import com.components.section.TTSectionImageFull
import com.model.SectionModel.ImageSection
import com.model.SectionModel.ImageSection.CardCarousel
import com.model.SectionModel.ImageSection.ImageFull

@Composable
fun BuildImageSection(params: BuildSectionParams) {
    val sectionModel = params.sectionModel as ImageSection
    when (sectionModel) {
        is CardCarousel -> TTSectionCardCarouselImage(params = params)
        is ImageFull -> TTSectionImageFull(params)
    }
}