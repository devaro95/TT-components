package com.components.icon

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.app.R
import com.components.styles.Primary
import com.components.text.TTBodyText
import com.components.text.TTHeaderText16
import com.components.text.TTTitleText16
import com.vro.compose.preview.VROLightMultiDevicePreview

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TTIconCarousel(
    modifier: Modifier = Modifier,
    items: List<TTIconCarouselItemData>,
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
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(items) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() },
                            onClick = { onItemClick() },
                        )
                    ) {
                        Image(
                            painter = painterResource(id = it.icon),
                            contentDescription = null,
                            modifier = Modifier
                                .clip(RoundedCornerShape(100.dp))
                                .size(50.dp)
                                .border(
                                    border = BorderStroke(1.5.dp, Primary),
                                    shape = RoundedCornerShape(100.dp)
                                )
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

data class TTIconCarouselItemData(
    val text: String,
    val icon: Int,
)
@VROLightMultiDevicePreview
@Composable
private fun TTIconCarouselPreview() {
    TTIconCarousel(
        items = listOf(
            TTIconCarouselItemData(
                text = "Comida",
                icon = R.drawable.ic_hamb
            ),
            TTIconCarouselItemData(
                text = "Museos",
                icon = R.drawable.ic_hamb
            ),
            TTIconCarouselItemData(
                text = "Rutas",
                icon = R.drawable.ic_hamb
            ),
            TTIconCarouselItemData(
                text = "Paises",
                icon = R.drawable.ic_hamb
            )
        ),
        onItemClick = {}
    )
}