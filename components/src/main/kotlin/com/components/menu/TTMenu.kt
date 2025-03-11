package com.components.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ttcomponents.app.R
import com.components.menu.TTMenuItemData.TTMenuItemClickableArrowData
import com.components.menu.TTMenuItemData.TTMenuItemSwitchData
import com.vro.compose.preview.VROLightMultiDevicePreview

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TTMenu(
    modifier: Modifier = Modifier,
    items: List<TTMenuItemData>,
) {
    Column(
        modifier = modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items.forEach {
            TTMenuItem(data = it)
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTMenuPreview() {
    TTMenu(
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