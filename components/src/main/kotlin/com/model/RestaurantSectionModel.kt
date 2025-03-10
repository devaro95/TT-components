package com.model

import com.model.GuideModel.ImageModel
import com.vro.constants.EMPTY_STRING
import com.vro.constants.INT_ZERO

data class RestaurantSectionModel(
    val name: String = EMPTY_STRING,
    val description: String = EMPTY_STRING,
    val imageList: List<ImageModel> = emptyList(),
    val price: RestaurantPriceModel = RestaurantPriceModel(INT_ZERO, EMPTY_STRING),
    val rate: RestaurantRateModel = RestaurantRateModel(INT_ZERO, EMPTY_STRING),
    val address: String = EMPTY_STRING,
    val menu: List<RestaurantMenu> = emptyList()
) {
    data class RestaurantMenu(
        val id: String,
        val name: String,
        val price: Int,
    )
}