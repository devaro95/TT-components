package com.model

import com.vro.constants.EMPTY_STRING

data class BulletSectionModel(
    val title: String = EMPTY_STRING,
    val text: String = EMPTY_STRING,
    val itemList: List<SectionItemModel> = emptyList(),
)
