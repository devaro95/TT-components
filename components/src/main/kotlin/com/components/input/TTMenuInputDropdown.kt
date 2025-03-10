package com.components.input

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.R
import com.components.icon.TTIcon
import com.components.styles.InputBorder
import com.components.styles.InputLegend
import com.components.styles.Placeholder
import com.components.styles.Primary
import com.components.styles.Secondary
import com.components.styles.SecondaryBackground
import com.vro.constants.EMPTY_STRING

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TTMenuInputDropdown(
    modifier: Modifier = Modifier,
    items: List<TTMenuInputDropdownItemData>,
    placeholder: String = EMPTY_STRING,
    selectedItem: TTMenuInputDropdownItemData? = null,
    selectedPosition: Int? = null,
    onItemSelected: ((TTMenuInputDropdownItemData) -> Unit)? = null,
    onClick: (() -> Unit)? = null,
) {
    Column(modifier = modifier) {
        var isExpanded by remember { mutableStateOf(false) }
        var isOpened by remember { mutableStateOf(false) }
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = {
                if (onClick == null) isExpanded = !isExpanded
                isOpened = !isOpened
            },
            modifier = Modifier
                .height(56.dp)
                .border(
                    border = BorderStroke(1.dp, InputBorder),
                    shape = RoundedCornerShape(10.dp)
                )
                .clip(RoundedCornerShape(10.dp))
                .background(SecondaryBackground)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .menuAnchor()
                    .clickable { onClick?.invoke() },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 16.dp)
                ) {
                    Text(
                        text = placeholder,
                        maxLines = 1,
                        style = TextStyle(
                            color = Primary,
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.main_font_medium))
                        ),
                        overflow = TextOverflow.Ellipsis,
                        color = Placeholder
                    )
                    if (selectedItem != null || selectedPosition != null) {
                        Text(
                            text = selectedPosition?.let {
                                items[selectedPosition].text
                            } ?: run {
                                selectedItem?.text ?: placeholder
                            },
                            style = MaterialTheme.typography.bodyMedium,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                        )
                    }
                }
                Column(modifier = Modifier.padding(end = 16.dp)) {
                    TTIcon(
                        iconRes = R.drawable.ic_back,
                        modifier = if (isOpened) Modifier.rotate(90f)
                        else Modifier.rotate(-90f),
                        tint = InputLegend
                    )
                }
            }
            if (onClick == null) {
                ExposedDropdownMenu(
                    expanded = isExpanded,
                    onDismissRequest = {
                        isExpanded = false
                        isOpened = !isOpened
                    },
                    modifier = Modifier.background(SecondaryBackground)
                ) {
                    items.forEach { item ->
                        DropdownMenuItem(
                            text = {
                                Text(item.text)
                            },
                            onClick = {
                                isExpanded = false
                                onItemSelected?.invoke(item)
                            },
                            colors = MenuDefaults.itemColors(
                                textColor = Secondary
                            )
                        )
                    }
                }
            }
        }
    }
}

data class TTMenuInputDropdownItemData(
    val value: Int,
    val text: String,
)

@Composable
@Preview(backgroundColor = 0xFFFFFFFF)
private fun TTMenuInputDropdownPreview() {
    TTMenuInputDropdown(
        placeholder = "Item Seleccionado",
        items = listOf(
            TTMenuInputDropdownItemData(
                value = 0,
                text = "10€"
            )
        ),
        onItemSelected = {}
    )
}