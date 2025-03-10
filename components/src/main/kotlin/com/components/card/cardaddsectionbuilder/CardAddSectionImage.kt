package com.components.card.cardaddsectionbuilder

import androidx.compose.runtime.Composable
import com.components.cardcarousel.TTCardCarouselImage
import com.components.image.TTImageFull
import com.components.section.TTSectionAdd
import com.domain.model.SectionModel
import com.domain.model.SectionModel.ImageSection.CardCarousel
import com.domain.model.SectionModel.ImageSection.ImageFull
import com.mock.imageModelMock
import com.mock.textMock

@Composable
fun CreateSectionImage(onSectionAddClick: (SectionModel) -> Unit) {
    TTSectionAdd(onSave = { onSectionAddClick.invoke(ImageFull()) }) {
        TTImageFull(
            image = imageModelMock,
            text = textMock
        )
    }
    TTSectionAdd(onSave = { onSectionAddClick.invoke(CardCarousel()) }) {
        TTCardCarouselImage(
            items = listOf(imageModelMock, imageModelMock, imageModelMock, imageModelMock),
            text = textMock
        )
    }
}