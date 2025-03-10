package com.components.card

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.card.TTCardAddImageCarouselType.BIG
import com.model.GuideModel.ImageModel
import com.vro.compose.preview.VROLightMultiDevicePreview

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TTCardAddImageCarousel(
    modifier: Modifier = Modifier,
    imageList: List<ImageModel>,
    type: TTCardAddImageCarouselType,
    onClick: (Int) -> Unit,
) {
    CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
        LazyRow(
            modifier = modifier,
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(imageList) { index, item ->
                TTCardAddImage(
                    modifier = Modifier
                        .width(type.width.dp)
                        .height(180.dp),
                    image = item,
                    onClick = { onClick.invoke(index) }
                )
            }
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTCardAddImagePreview() {
    TTCardAddImageCarousel(
        imageList = listOf(ImageModel(), ImageModel()),
        type = BIG,
        onClick = {},
    )
}

enum class TTCardAddImageCarouselType(val width: Int) {
    SMALL(180), BIG(300)
}