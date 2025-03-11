package com.components.grid.item

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.ttcomponents.app.R
import com.components.grid.data.TTGridItemData
import com.components.icon.TTIcon
import com.components.styles.Background
import com.components.styles.Primary
import com.components.styles.Secondary
import com.components.styles.White
import com.components.text.TTHeaderText14
import com.vro.compose.preview.VROLightMultiDevicePreview

@Composable
fun TTDeletableGridItem(
    item: TTGridItemData,
    onDeleteClick: (id: Int) -> Unit,
    isSelected: Boolean
) {
    Box {
        Row(
            modifier = Modifier
                .padding(
                    top = 8.dp,
                    end = 8.dp
                )
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) Secondary else Background)
                .border(2.dp, Secondary, RoundedCornerShape(10.dp))
        ) {
            TTHeaderText14(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
                text = item.value,
                color = if (isSelected) White else Primary
            )
        }
        Row(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .border(1.dp, Background, CircleShape)
                .clip(CircleShape)
                .background(Primary)
                .size(20.dp),
        ) {
            TTIcon(
                modifier = Modifier.padding(6.dp),
                iconRes = R.drawable.ic_cross,
                tint = White,
                onClick = { onDeleteClick(item.id) }
            )
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTDeletableGridItemPreview() {
    TTDeletableGridItem(
        TTGridItemData(
            id = 0, value = "Test"
        ),
        onDeleteClick = {},
        isSelected = true
    )
}