package com.mapper

import com.app.R
import  com.model.AvatarModel
import  com.model.AvatarModel.AVOCADO
import  com.model.AvatarModel.BEAR
import  com.model.AvatarModel.CACTUS
import  com.model.AvatarModel.LAZYBONES
import com.vro.constants.INT_ZERO

fun AvatarModel.toDrawable() = when (this) {
    AVOCADO -> R.drawable.ic_avatar_avocado
    CACTUS -> R.drawable.ic_avatar_cactus
    LAZYBONES -> R.drawable.ic_avatar_lazybones
    BEAR -> R.drawable.ic_avatar_bear
    AvatarModel.CUSTOM -> INT_ZERO
}
