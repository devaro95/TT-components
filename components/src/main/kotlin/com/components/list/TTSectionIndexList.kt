package com.components.list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.dp
import com.components.listitem.TTSectionListItem
import com.vro.compose.preview.VROLightMultiDevicePreview

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TTSectionIndexList(
    itemList: List<TTSectionIndexItemData>,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
        LazyColumn(
            contentPadding = contentPadding,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(itemList) {
                TTSectionListItem(
                    title = it.title,
                    description = it.text,
                    onClick = it.onClick
                )
            }
        }
    }
}

data class TTSectionIndexItemData(
    val title: String,
    val text: String,
    val onClick: () -> Unit,
)

@VROLightMultiDevicePreview
@Composable
private fun TTSectionIndexListPreview() {
    TTSectionIndexList(
        listOf(
            TTSectionIndexItemData(
                title = "Párrafo",
                text = "¿Y si le añadimos una imagen?",
                onClick = { }
            )
        )
    )
}