package com.components.icon

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.app.R
import com.vro.compose.preview.VROLightMultiDevicePreview

@VROLightMultiDevicePreview
@Composable
private fun TTIconLikePreview() {
    TTIconLike(
        isLiked = false,
        onClick = {}
    )
}

@Composable
fun TTIconLike(
    modifier: Modifier = Modifier,
    isLiked: Boolean,
    size: Dp? = null,
    contentDescription: String? = null,
    onClick: (() -> Unit)? = null,
    tint: Color? = null,
) {
    Column(modifier = Modifier.clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() },
        onClick = { onClick?.invoke() }
    )) {
        Icon(
            painter = painterResource(
                id = if (isLiked) R.drawable.ic_like_fill
                else R.drawable.ic_like_empty
            ),
            contentDescription = contentDescription,
            tint = tint ?: MaterialTheme.colorScheme.primary,
            modifier = modifier.setSize(size)
        )
    }
}