package com.components.cardcarousel

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ttcomponents.app.R
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.components.text.*
import com.extensions.jumpOnSpace
import com.vro.compose.preview.VROLightMultiDevicePreview

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TTCardCarouselTitle(
    modifier: Modifier = Modifier,
    title: String? = null,
    description: String? = null,
    items: List<TTCardCarouselTitleItem>,
    onClick: (Int) -> Unit,
) {
    Column(modifier = modifier) {
        title?.let {
            TTHeaderText16(
                text = it,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )

        }
        description?.let {
            TTTitleText16(
                text = it,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
            LazyRow(
                modifier = Modifier.padding(top = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(items) {
                    TTCardCarouselTitleItem(it, onClick)
                }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun TTCardCarouselTitleItem(
    item: TTCardCarouselTitleItem,
    onClick: (Int) -> Unit,
) {
    Box(
        modifier = Modifier
            .width(180.dp)
            .height(200.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = { onClick.invoke(item.id) },
            )
    ) {
        GlideImage(
            model = item.image,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        TTHeaderTextVariant(
            text = item.title.jumpOnSpace(),
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(10.dp),
            fontSize = 20.sp
        )
    }
}

data class TTCardCarouselTitleItem(
    val id: Int,
    val title: String,
    val image: Int,
)

@VROLightMultiDevicePreview
@Composable
private fun TTCardCarouselTitlePreview() {
    TTCardCarouselTitle(
        items = listOf(
            TTCardCarouselTitleItem(
                id = 0,
                image = R.drawable.country,
                title = "Reino Unido"
            ),
            TTCardCarouselTitleItem(
                id = 1,
                image = R.drawable.country,
                title = "España"
            )
        ),
        onClick = {}
    )
}