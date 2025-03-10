package com.components.container

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.components.footer.TTGuideStats
import com.components.styles.GuideCardHeader
import com.components.text.TTBodyText
import com.components.text.TTHeaderText18
import  com.domain.model.GuideModel
import com.vro.compose.preview.VROLightMultiDevicePreview

@Composable
fun TTGuideContainer(
    modifier: Modifier = Modifier,
    guide: GuideModel,
    onClick: (guide: GuideModel) -> Unit,
    onSaveClick: (isLiked: Boolean, id: String) -> Unit,
    onLikeClick: (isLiked: Boolean, id: String) -> Unit,
) {
    Column(
        modifier = modifier.clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() },
            onClick = { onClick(guide) })
    ) {
        Column(
            modifier = Modifier
                .padding(
                    vertical = 16.dp
                )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = guide.username,
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 12.sp,
                    color = GuideCardHeader
                )
                Text(
                    text = guide.creationDate,
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 12.sp,
                    color = GuideCardHeader
                )
            }
            TTHeaderText18(
                modifier = Modifier.padding(top = 8.dp),
                text = guide.title
            )
            TTBodyText(
                modifier = Modifier.padding(top = 4.dp),
                text = guide.description,
                maxLines = 6,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.End
            ) {
                TTGuideStats(
                    userLiked = guide.userLiked,
                    onLikeClick = { onLikeClick(guide.userLiked, guide.id) },
                    totalLikes = guide.totalLikes,
                    userSaved = guide.userSaved,
                    onSaveClick = { onSaveClick.invoke(guide.userSaved, guide.id) },
                    totalSaves = guide.totalSaves,
                )
            }
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTGuideContainerPreview() {
    TTGuideContainer(
        guide = GuideModel(
            username = "devaro95",
            title = "Guía por España",
            description = "Descubre los lugares más fascinantes en la España escondida."
        ),
        onClick = {},
        onSaveClick = { _, _ -> },
        onLikeClick = { _, _ -> }
    )
}