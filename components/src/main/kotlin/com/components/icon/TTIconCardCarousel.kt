package com.components.icon

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.app.R
import com.components.styles.CardBackground
import com.components.text.TTBodyText
import com.components.text.TTHeaderText16
import com.components.text.TTTitleText16
import com.vro.compose.preview.VROLightMultiDevicePreview
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TTIconCardCarousel(
    modifier: Modifier = Modifier,
    items: ImmutableList<TTIconCardCarouselItemData>,
    title: String? = null,
    description: String? = null,
    onItemClick: () -> Unit,
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
                    ElevatedCard(
                        modifier = Modifier
                            .width(90.dp)
                            .height(90.dp),
                        colors = CardDefaults.elevatedCardColors(
                            containerColor = CardBackground
                        ),
                        elevation = CardDefaults.elevatedCardElevation(
                            defaultElevation = 6.dp
                        )
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .clickable(
                                    indication = null,
                                    interactionSource = remember { MutableInteractionSource() },
                                    onClick = { onItemClick() },
                                )
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = it.icon),
                                contentDescription = null,
                                modifier = Modifier.size(32.dp)
                            )
                            TTBodyText(
                                text = it.text,
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

data class TTIconCardCarouselItemData(
    val text: String,
    val icon: Int,
)

@VROLightMultiDevicePreview
@Composable
private fun TTIconCardCarouselPreview() {
    TTIconCardCarousel(
        items = persistentListOf(
            TTIconCardCarouselItemData(
                text = "Comida",
                icon = R.drawable.ic_hamb
            ),
            TTIconCardCarouselItemData(
                text = "Museos",
                icon = R.drawable.ic_hamb
            ),
            TTIconCardCarouselItemData(
                text = "Rutas",
                icon = R.drawable.ic_hamb
            ),
            TTIconCardCarouselItemData(
                text = "Paises",
                icon = R.drawable.ic_hamb
            )
        ),
        onItemClick = {}
    )
}