package com.components.cardcarousel

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.ttcomponents.app.R
import com.components.styles.CardBackground
import com.components.text.TTHeaderText16
import com.components.text.TTHeaderText18
import com.components.text.TTTitleText16
import com.vro.compose.preview.VROLightMultiDevicePreview

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TTCardCarouselTitleNew(
    modifier: Modifier = Modifier,
    title: String? = null,
    description: String? = null,
    items: List<TTCardCarouselTitleItem>,
    onCardClick: (Int) -> Unit,
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
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(items) {
                    TTCardCarouselTitleNewItem(it, onCardClick)
                }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun TTCardCarouselTitleNewItem(
    item: TTCardCarouselTitleItem,
    onCardClick: (Int) -> Unit,
) {
    ElevatedCard(
        modifier = Modifier
            .width(260.dp)
            .height(250.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = CardBackground
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 6.dp
        ),
        onClick = { onCardClick.invoke(item.id) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(CardBackground)
        ) {
            GlideImage(
                modifier = Modifier.height(200.dp),
                model = item.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Column(
                Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                TTHeaderText18(
                    modifier = Modifier.padding(start = 16.dp),
                    text = item.title
                )
            }
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTCardCarouselTitleNewPreview() {
    TTCardCarouselTitleNew(
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
        onCardClick = {}
    )
}
