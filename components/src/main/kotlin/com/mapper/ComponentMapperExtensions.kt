package com.mapper

import com.ttcomponents.app.R
import  com.domain.model.AvatarModel
import  com.domain.model.AvatarModel.AVOCADO
import  com.domain.model.AvatarModel.BEAR
import  com.domain.model.AvatarModel.CACTUS
import  com.domain.model.AvatarModel.LAZYBONES
import com.vro.constants.INT_ZERO

fun AvatarModel.toDrawable() = when (this) {
    AVOCADO -> R.drawable.ic_avatar_avocado
    CACTUS -> R.drawable.ic_avatar_cactus
    LAZYBONES -> R.drawable.ic_avatar_lazybones
    BEAR -> R.drawable.ic_avatar_bear
    AvatarModel.CUSTOM -> INT_ZERO
}
