package com.components.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ttcomponents.app.R
import com.components.input.TTInput
import com.components.text.TTHeaderText18
import com.components.text.TTTitleText16
import com.mock.titleMock
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING
import java.io.Serializable

@Composable
fun TTCardSelectorList(
    modifier: Modifier = Modifier,
    header: String?,
    subheader: String? = null,
    items: List<TTCardSelectorItem>,
    selectedValues: List<TTCardSelectorItem?>,
    onClick: (TTCardSelectorItem) -> Unit,
    multiSelection: Boolean = false,
    isVisible: Boolean = true,
    otherItem: TTCardSelectorOther = TTCardSelectorOther(),
) {
    if (isVisible) {
        Column(modifier = modifier) {
            header?.let {
                TTHeaderText18(
                    modifier = Modifier.padding(top = 16.dp),
                    text = it
                )
            }
            val text = when {
                subheader == null && multiSelection -> stringResource(id = R.string.multiple_selection_subheader)
                else -> subheader
            }
            text?.let {
                TTTitleText16(
                    modifier = Modifier.padding(top = 8.dp),
                    text = text
                )
            }
            items.forEach {
                TTCardSelector(
                    modifier = Modifier.padding(top = 12.dp),
                    item = it,
                    selected = it in selectedValues,
                    onClick = { value -> onClick(value) },
                    multiSelection = multiSelection
                )
            }
            if (otherItem.isVisible) {
                TTInput(
                    modifier = Modifier.padding(top = 8.dp),
                    value = otherItem.value,
                    onChange = { otherItem.onChange(it) },
                    placeholder = otherItem.placeholder
                )
            }
        }
    }
}

data class TTCardSelectorOther(
    val isVisible: Boolean = false,
    val value: String = EMPTY_STRING,
    val onChange: (String) -> Unit = {},
    val placeholder: String = EMPTY_STRING,
)

data class TTCardSelectorItem(
    val text: String,
    val value: Serializable,
) : Serializable

@VROLightMultiDevicePreview
@Composable
private fun TTCardSelectorListPreview() {
    val item = TTCardSelectorItem(text = titleMock, value = 1)
    TTCardSelectorList(
        items = listOf(item),
        header = titleMock,
        selectedValues = listOf(item),
        onClick = {}
    )
}