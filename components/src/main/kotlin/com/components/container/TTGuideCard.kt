package com.components.container

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.ttcomponents.app.R
import com.components.button.TTButtonIconSquare
import com.components.styles.Secondary
import com.components.text.TTBodyText14
import com.components.text.TTHeaderText16
import  com.domain.model.GuideModel
import com.mock.guideMock
import com.vro.compose.preview.VROLightMultiDevicePreview

@Composable
fun TTGuideCard(
    guide: GuideModel,
    onClick: (GuideModel) -> Unit,
    onSaveClick: (isSaved: Boolean, id: String) -> Unit,
    onLikeClick: (isLiked: Boolean, id: String) -> Unit,
) {
    Box(
        modifier = Modifier
            .height(230.dp)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = { onClick(guide) },
            )
    ) {
        SubcomposeAsyncImage(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(10.dp)),
            model = guide.image.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            loading = {
                Column(
                    modifier = Modifier.size(30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator(
                        color = Secondary
                    )
                }
            }
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(10.dp))
        ) {
            Row(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(16.dp),
                horizontalArrangement = Arrangement.End
            ) {
                TTButtonIconSquare(
                    text = guide.totalLikes.toString(),
                    iconRes = if (guide.userLiked) R.drawable.ic_like_fill
                    else R.drawable.ic_like_empty,
                    onClick = { onLikeClick(guide.userLiked, guide.id) }
                )
                TTButtonIconSquare(
                    modifier = Modifier.padding(start = 8.dp),
                    text = guide.totalSaves.toString(),
                    iconRes = if (guide.userSaved) R.drawable.ic_save_fill
                    else R.drawable.ic_save_empty,
                    onClick = { onSaveClick(guide.userSaved, guide.id) }
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xD8FFFFFF))
                    .padding(16.dp)
            ) {
                TTHeaderText16(
                    text = guide.title
                )
                TTBodyText14(
                    modifier = Modifier.padding(top = 8.dp),
                    text = guide.description,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    minLines = 3
                )
            }
        }
    }
}

@VROLightMultiDevicePreview
@Composable
fun TTGuideCardPreview() {
    TTGuideCard(
        guide = guideMock,
        onClick = {},
        onLikeClick = { _, _ -> },
        onSaveClick = { _, _ -> },
    )
}