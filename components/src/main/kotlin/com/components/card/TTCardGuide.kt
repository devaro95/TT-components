package com.components.card

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.components.footer.TTGuideStats
import com.components.styles.*
import com.components.text.TTBodyText
import com.components.text.TTHeaderText18
import com.domain.model.GuideModel
import com.vro.compose.preview.VROLightMultiDevicePreview

@Deprecated(
    message = "Old Used form",
    replaceWith = ReplaceWith("Replace with TTGuideCard")
)
@Composable
fun TTCardGuide(
    modifier: Modifier = Modifier,
    guide: GuideModel,
    onClick: (guide: GuideModel) -> Unit,
    onSaveClick: (isLiked: Boolean, id: String) -> Unit,
    onLikeClick: (isLiked: Boolean, id: String) -> Unit,
) {
    TTCardElevated(
        modifier = modifier.border(1.dp, CardBorder, RoundedCornerShape(10.dp)),
        onClick = { onClick(guide) },
    ) {
        Column {
            Column(
                modifier = Modifier
                    .background(CardBackground)
                    .padding(
                        horizontal = 16.dp,
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
                        .padding(top = 8.dp),
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
}

@VROLightMultiDevicePreview
@Composable
private fun TTCardGuidePreview() {
    TTCardGuide(
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