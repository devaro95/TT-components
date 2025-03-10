package com.components.card

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.components.styles.Secondary
import com.components.text.TTHeaderText16
import com.mock.titleMock
import com.vro.compose.preview.VROLightMultiDevicePreview

@Composable
fun TTCardSelector(
    modifier: Modifier = Modifier,
    item: TTCardSelectorItem,
    selected: Boolean,
    onClick: (TTCardSelectorItem) -> Unit,
    multiSelection: Boolean = false,
) {
    TTCardElevated(
        modifier.fillMaxWidth(),
        onClick = { if (!selected || multiSelection) onClick(item) }
    ) {
        Box(
            modifier = Modifier
                .padding(
                    horizontal = 24.dp,
                    vertical = 24.dp
                )
                .fillMaxWidth()
        ) {
            TTHeaderText16(
                modifier = Modifier.align(Alignment.CenterStart),
                text = item.text
            )
            if (!multiSelection) {
                Column(
                    Modifier
                        .align(Alignment.CenterEnd)
                        .size(16.dp)
                        .border(1.dp, Secondary, RoundedCornerShape(100.dp)),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (selected) {
                        Spacer(
                            Modifier
                                .size(10.dp)
                                .clip(RoundedCornerShape(100.dp))
                                .background(Secondary)
                        )
                    }
                }
            } else {
                Column(
                    Modifier
                        .align(Alignment.CenterEnd)
                        .size(16.dp)
                        .border(1.dp, Secondary),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (selected) {
                        Spacer(
                            Modifier
                                .size(10.dp)
                                .background(Secondary)
                        )
                    }
                }
            }
        }
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTCardSelectorPreview() {
    TTCardSelector(
        item = TTCardSelectorItem(titleMock, 1),
        selected = true,
        onClick = {},
        multiSelection = true
    )
}