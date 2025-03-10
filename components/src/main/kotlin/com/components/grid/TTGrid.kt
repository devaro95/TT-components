package com.components.grid

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.components.grid.data.TTGridItemData
import com.components.styles.Background
import com.components.styles.Primary
import com.components.styles.Secondary
import com.components.styles.White
import com.components.text.TTHeaderText14
import com.components.text.TTHeaderText24
import com.components.text.TTHeaderTextCustom
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TTGrid(
    modifier: Modifier = Modifier,
    title: String = EMPTY_STRING,
    items: List<TTGridItemData>,
    selectedItems: List<TTGridItemData>,
    onItemClick: (id: Int) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        if (title.isNotEmpty()) {
            TTHeaderTextCustom(
                text = title,
                fontSize = 20.sp
            )
        }
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items.forEach { item ->
                TTGridItem(
                    item = item,
                    onClick = onItemClick,
                    isSelected = selectedItems.contains(item)
                )
            }
        }
    }
}

@Composable
fun TTGridItem(
    item: TTGridItemData,
    onClick: (id: Int) -> Unit,
    isSelected: Boolean
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(if (isSelected) Secondary else Background)
            .border(2.dp, Secondary, RoundedCornerShape(10.dp))
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = { onClick(item.id) },
            )
    ) {
        TTHeaderText14(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
            text = item.value,
            color = if (isSelected) White else Primary
        )
    }
}


@VROLightMultiDevicePreview
@Composable
private fun TTGridItemPreview() {
    Row(
        Modifier
            .padding(16.dp)
    ) {
        TTGridItem(
            TTGridItemData(
                id = 0, value = "Test"
            ),
            onClick = {},
            isSelected = true
        )
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTGridPreview() {
    TTGrid(
        title = "Categorías",
        items = listOf(
            TTGridItemData(id = 0, value = "Test"),
            TTGridItemData(id = 0, value = "Test 1aaaaa"),
            TTGridItemData(id = 0, value = "Test 2"),
            TTGridItemData(id = 0, value = "Test 3wwww"),
            TTGridItemData(id = 0, value = "Test 4"),
            TTGridItemData(id = 0, value = "Test 5sss"),
            TTGridItemData(id = 0, value = "Test 6ddd"),
            TTGridItemData(id = 0, value = "Test 7")
        ),
        onItemClick = {},
        selectedItems = emptyList()
    )
}