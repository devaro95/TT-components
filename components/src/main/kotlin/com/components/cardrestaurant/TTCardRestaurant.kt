package com.components.cardrestaurant

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.app.R
import com.components.cardcarousel.TTCardCarouselImage
import com.components.cardrestaurant.TTCardRestaurantType.BOTTOM_FULL
import com.components.cardrestaurant.TTCardRestaurantType.TOP_FULL
import com.components.cardrestaurant.TTCardRestaurantType.TOP_RIGHT
import com.components.text.TTAddressText
import com.components.text.TTBodyText
import com.components.text.TTHeaderText16
import com.components.text.TTHeaderText18
import com.components.text.TTItalicText
import com.components.text.TTTextBorderIcon
import  com.model.RestaurantSectionModel
import com.extensions.toDashedText
import com.extensions.toEurosText
import com.mock.addressMock
import com.mock.imageModelMock
import com.mock.menuMock
import com.mock.restaurantPriceMock
import com.mock.restaurantRateMock
import com.mock.textMock
import com.vro.compose.preview.VROLightMultiDevicePreview

@Composable
fun TTCardRestaurant(
    modifier: Modifier = Modifier,
    item: RestaurantSectionModel,
    type: TTCardRestaurantType,
) {
    Column(modifier = modifier) {
        TTHeaderText18(
            text = item.name,
            modifier = Modifier.padding(bottom = if (type == BOTTOM_FULL) 0.dp else 16.dp)
        )

        if (type == TOP_FULL) {
            TTCardCarouselImage(
                items = item.imageList,
                itemModifier = Modifier.clip(RoundedCornerShape(16.dp)),
                pageSpacing = 16.dp
            )
        }
        Row(modifier = Modifier.padding(top = 10.dp)) {
            TTTextBorderIcon(
                label = stringResource(R.string.create_section_restaurant_label_rate),
                text = item.rate.value,
                icon = R.drawable.ic_star
            )
            TTTextBorderIcon(
                modifier = Modifier.padding(start = 10.dp),
                label = stringResource(R.string.create_section_restaurant_label_price),
                text = item.price.value,
                icon = R.drawable.ic_diamond
            )
        }
        TTAddressText(
            text = item.address,
            modifier = Modifier.padding(top = 8.dp)
        )
        TTBodyText(
            text = item.description,
            modifier = Modifier.padding(
                top = 16.dp,
                bottom = if (type == BOTTOM_FULL) 8.dp else 0.dp
            )
        )
        if (type == BOTTOM_FULL) {
            TTCardCarouselImage(
                items = item.imageList,
                itemModifier = Modifier.clip(RoundedCornerShape(16.dp)),
                pageSpacing = 16.dp
            )
        }
        if (item.menu.isNotEmpty()) {
            TTHeaderText16(
                text = stringResource(id = R.string.card_restaurant_what_to_take),
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
            )
            item.menu.forEach {
                Row(
                    modifier = Modifier
                        .padding(bottom = 6.dp)
                        .fillMaxWidth()
                ) {
                    TTItalicText(
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 16.dp),
                        text = it.name.toDashedText()
                    )
                    TTItalicText(
                        text = it.price.toEurosText()
                    )
                }
            }
        }
    }
}

enum class TTCardRestaurantType {
    TOP_FULL, TOP_LEFT, TOP_RIGHT, BOTTOM_FULL
}

@VROLightMultiDevicePreview
@Composable
private fun TTCardRestaurantPreview() {
    TTCardRestaurant(
        item = RestaurantSectionModel(
            name = "Restaurant Title",
            description = textMock,
            imageList = listOf(imageModelMock),
            rate = restaurantRateMock,
            price = restaurantPriceMock,
            address = addressMock,
            menu = menuMock,
        ),
        type = TOP_RIGHT
    )
}
