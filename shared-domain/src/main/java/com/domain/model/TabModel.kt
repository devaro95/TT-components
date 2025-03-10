package com.domain.model

import com.vro.constants.EMPTY_STRING

data class TabModel(
    val id: String = EMPTY_STRING,
    val title: String = EMPTY_STRING,
    val sections: List<SectionModel> = emptyList()
)