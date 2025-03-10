package com.components.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.app.R
import com.components.menu.TTMenuItemData.TTMenuItemClickableArrowData
import com.components.menu.TTMenuItemData.TTMenuItemSwitchData
import com.components.styles.InputBorder
import com.components.styles.SecondaryBackground
import com.components.text.TTHeaderText14
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TTMenuRounded(
    modifier: Modifier = Modifier,
    title: String = EMPTY_STRING,
    items: List<TTMenuItemData>,
) {
    Column(modifier) {
        TTHeaderText14(
            modifier = Modifier.padding(start = 8.dp),
            text = title
        )
        Column(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .border(1.dp, InputBorder, RoundedCornerShape(16.dp))
                .clip(RoundedCornerShape(16.dp))
                .background(SecondaryBackground)
                .padding(vertical = 16.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            items.forEach {
                TTMenuItem(data = it)
            }
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTMenuPreview() {
    TTMenuRounded(
        title = "Title",
        items = listOf(
            TTMenuItemClickableArrowData(
                icon = R.drawable.ic_delete_2,
                text = "Example",
                onClick = {}
            ),
            TTMenuItemClickableArrowData(
                icon = R.drawable.ic_delete_2,
                text = "Example",
                onClick = {}
            ),
            TTMenuItemSwitchData(
                icon = R.drawable.ic_delete_2,
                text = "Example",
                isChecked = false,
                onChange = {},
            )
        )
    )
}