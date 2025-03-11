package com.components.footer

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ttcomponents.app.R
import com.components.icon.TTIcon
import com.components.icon.TTIconLike
import com.components.styles.Primary
import com.components.text.TTBodyText14

@Composable
fun TTGuideStats(
    modifier: Modifier = Modifier,
    userLiked: Boolean,
    onLikeClick: () -> Unit,
    totalLikes: Int,
    userSaved: Boolean,
    onSaveClick: () -> Unit,
    totalSaves: Int,
    tint: Color = Primary
) {
    Row(modifier) {
        TTIconLike(
            isLiked = userLiked,
            size = 18.dp,
            onClick = onLikeClick,
            tint = tint
        )
        TTBodyText14(
            modifier = Modifier.padding(start = 4.dp),
            text = totalLikes.toString(),
            color = tint
        )
        TTIcon(
            modifier = Modifier.padding(start = 8.dp),
            iconRes = if (userSaved) R.drawable.ic_save_fill
            else R.drawable.ic_save_empty,
            size = 18.dp,
            onClick = onSaveClick,
            tint = tint
        )
        TTBodyText14(
            modifier = Modifier.padding(start = 4.dp),
            text = totalSaves.toString(),
            color = tint
        )
    }
}