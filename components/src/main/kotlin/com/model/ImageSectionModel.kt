package com.model

import com.model.GuideModel.ImageModel
import com.vro.constants.EMPTY_STRING

data class ImageSectionModel(
    val text: String = EMPTY_STRING,
    val itemList: List<ImageModel> = emptyList(),
)
