package com.model

import com.vro.constants.EMPTY_STRING

data class RouteSectionModel(
    val title: String = EMPTY_STRING,
    val itemList: List<SectionItemModel> = emptyList(),
)