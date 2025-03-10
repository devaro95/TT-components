package com.components.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.components.styles.White
import  com.model.AvatarModel
import com.mapper.toDrawable

@Composable
fun TTUserImage(
    modifier: Modifier = Modifier,
    size: Dp,
    image: String,
    defaultAvatar: AvatarModel? = null
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .border(width = 2.dp, White, CircleShape)
    ) {
        if (defaultAvatar != AvatarModel.CUSTOM && defaultAvatar != null) {
            Image(
                painterResource(defaultAvatar.toDrawable()),
                contentDescription = null
            )
        } else if (image.isNotEmpty()) {
            AsyncImage(
                modifier = Modifier.size(size),
                model = image,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}