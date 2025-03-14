package com.domain.model

import com.vro.constants.EMPTY_STRING

data class SectionItemModel(
    val id: String,
    val title: String = EMPTY_STRING,
    val text: String = EMPTY_STRING,
)
