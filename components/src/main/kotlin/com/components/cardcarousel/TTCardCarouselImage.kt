package com.components.cardcarousel

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.components.text.TTBodyText
import com.extensions.toBitmap
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.mock.imageModelMock
import com.mock.textLongMock
import com.domain.model.GuideModel.ImageModel
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING
import com.vro.constants.INT_ONE
import dev.chrisbanes.snapper.ExperimentalSnapperApi

@VROLightMultiDevicePreview
@Composable
private fun TTCardCarouselImagePreview() {
    TTCardCarouselImage(
        items = listOf(imageModelMock, imageModelMock),
        text = textLongMock
    )
}

@OptIn(ExperimentalSnapperApi::class)
@Composable
fun TTCardCarouselImage(
    modifier: Modifier = Modifier,
    itemModifier: Modifier = Modifier,
    items: List<ImageModel> = emptyList(),
    text: String = EMPTY_STRING,
    height: Dp = 240.dp,
    pageSpacing: Dp = 0.dp,
) {
    val state = rememberPagerState(pageCount = { items.size })

    Column {
        HorizontalPager(
            modifier = modifier,
            state = state,
            pageSpacing = pageSpacing,
            userScrollEnabled = items.size > INT_ONE
        ) {
            TTCardCarouselImageItem(
                modifier = itemModifier,
                item = items[it],
                height = height
            )
        }
        if (items.size > INT_ONE) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                HorizontalPagerIndicator(
                    pageCount = items.size,
                    pagerState = state
                )
            }
        }
        if (text.isNotEmpty()) {
            TTBodyText(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .padding(horizontal = 16.dp),
                text = text
            )
        }
    }
}

@Composable
fun PagerScope.TTCardCarouselImageItem(
    item: ImageModel,
    height: Dp,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height),
    ) {
        if (item.imageUrl.isEmpty()) {
            Image(
                bitmap = item.imageBase64.toBitmap().asImageBitmap(),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        } else {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize(),
                model = item.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}