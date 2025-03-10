package com.domain.model

import com.vro.constants.EMPTY_STRING
import com.vro.constants.INT_ZERO

data class GuideModel(
    val id: String = EMPTY_STRING,
    val username: String = EMPTY_STRING,
    val avatar: String = EMPTY_STRING,
    val defaultAvatar: AvatarModel? = null,
    val userId: String = EMPTY_STRING,
    val title: String = EMPTY_STRING,
    val description: String = EMPTY_STRING,
    val image: ImageModel = ImageModel(),
    val tabs: List<TabModel> = listOf(TabModel()),
    val categories: List<CategoryModel> = emptyList(),
    val countries: List<CountryModel> = emptyList(),
    val userLiked: Boolean = false,
    val userSaved: Boolean = false,
    val totalLikes: Int = INT_ZERO,
    val totalSaves: Int = INT_ZERO,
    val creationDate: String = EMPTY_STRING,
    val isUserGuide: Boolean = false,
) {
    data class ImageModel(
        val imageUrl: String = EMPTY_STRING,
        val imageBase64: String = EMPTY_STRING,
        val imageId: String = EMPTY_STRING,
        val imageArray: ByteArray? = byteArrayOf(),
    )
}