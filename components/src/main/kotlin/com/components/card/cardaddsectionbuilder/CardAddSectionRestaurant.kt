package com.components.card.cardaddsectionbuilder

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.components.cardrestaurant.TTCardRestaurant
import com.components.cardrestaurant.TTCardRestaurantType
import com.components.section.TTSectionAdd
import com.mock.*
import com.domain.model.RestaurantSectionModel
import com.domain.model.SectionModel
import com.domain.model.SectionModel.RestaurantSection.BottomImage
import com.domain.model.SectionModel.RestaurantSection.TopImage

@Composable
fun CreateSectionRestaurant(onSectionAddClick: (SectionModel) -> Unit) {
    //CreateRestaurantCard(
    //    type = TTCardRestaurantType.TOP_LEFT,
    //    onSave = { onSectionAddClick(TopLeftImage()) }
    //)
    //CreateRestaurantCard(
    //    type = TTCardRestaurantType.TOP_RIGHT,
    //    onSave = { onSectionAddClick(TopRightImage()) }
    //)
    CreateRestaurantCard(
        type = TTCardRestaurantType.TOP_FULL,
        onSave = { onSectionAddClick(TopImage()) }
    )
    CreateRestaurantCard(
        type = TTCardRestaurantType.BOTTOM_FULL,
        onSave = { onSectionAddClick(BottomImage()) }
    )
}

@Composable
private fun CreateRestaurantCard(
    type: TTCardRestaurantType,
    onSave: () -> Unit,
) {
    TTSectionAdd(onSave = onSave) {
        TTCardRestaurant(
            modifier = Modifier.padding(horizontal = 16.dp),
            item = RestaurantSectionModel(
                name = "Nombre del restaurante",
                description = textMock,
                imageList = listOf(imageModelMock),
                rate = restaurantRateMock,
                price = restaurantPriceMock,
                address = addressMock,
                menu = emptyList(),
            ), type = type
        )
    }
}