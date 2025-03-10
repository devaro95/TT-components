package com.components.input

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
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
import com.components.text.TTBodyText
import com.components.text.TTHeaderTextVariant

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TTInputCurrencyPicker(
    modifier: Modifier = Modifier,
    items: List<TTMenuInputDropdownItemData>,
    selected: TTMenuInputDropdownItemData? = null,
    placeholder: String,
    currency: String,
    symbol: String,
    onPriceSelected: ((TTMenuInputDropdownItemData) -> Unit)? = null,
    onCurrencyClick: () -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }
    Row(
        modifier = modifier
            .height(56.dp)
            .background(SecondaryBackground)
            .border(
                width = 1.dp,
                color = InputBorder,
                shape = RoundedCornerShape(8.dp)
            )
            .clip(RoundedCornerShape(10.dp)),
    ) {
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = {
                isExpanded = !isExpanded
            },
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(10.dp))
                .background(SecondaryBackground),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .menuAnchor(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(16.dp))
                selected?.let {
                    TTBodyText(text = selected.text)
                } ?: run {
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
                }
                Spacer(modifier = Modifier.width(16.dp))
                TTIcon(
                    modifier = Modifier.rotate(-90f),
                    iconRes = R.drawable.ic_back,
                    onClick = { },
                    tint = InputLegend
                )

            }
            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = {
                    isExpanded = false
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
                            onPriceSelected?.invoke(item)
                        },
                        colors = MenuDefaults.itemColors(
                            textColor = Secondary
                        )
                    )
                }
            }
        }
        VerticalDivider(modifier = Modifier.padding(vertical = 16.dp))

        Row(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = { onCurrencyClick() }
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(26.dp)
                    .clip(CircleShape)
                    .background(Secondary)
            ) {
                TTHeaderTextVariant(
                    modifier = Modifier.align(Alignment.Center),
                    text = symbol,
                    fontSize = 14.sp
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            TTBodyText(text = currency)
            Spacer(modifier = Modifier.width(16.dp))
            TTIcon(
                modifier = Modifier.rotate(-90f),
                iconRes = R.drawable.ic_back,
                onClick = { onCurrencyClick() },
                tint = InputLegend
            )
        }
    }
}

@Composable
@Preview(backgroundColor = 0xFFFFFFFF)
private fun TTInputCurrencyPickerPreview() {
    Column {
        TTInputCurrencyPicker(
            placeholder = "Precio",
            currency = "USD",
            items = listOf(
                TTMenuInputDropdownItemData(value = 1, "asd"),
                TTMenuInputDropdownItemData(value = 2, "asd")
            ),
            symbol = "$",
            onCurrencyClick = {}
        )
        Spacer(modifier = Modifier.height(16.dp))
        TTInputCurrencyPicker(
            selected = TTMenuInputDropdownItemData(value = 1, "asd"),
            placeholder = "Precio",
            currency = "EUR",
            items = listOf(
                TTMenuInputDropdownItemData(value = 1, "asd"),
                TTMenuInputDropdownItemData(value = 2, "asd")
            ),
            symbol = "$",
            onCurrencyClick = {}
        )
        Spacer(modifier = Modifier.height(16.dp))
        TTInputCurrencyPicker(
            selected = TTMenuInputDropdownItemData(value = 1, "asd"),
            placeholder = "Precio",
            currency = "EUR",
            items = listOf(
                TTMenuInputDropdownItemData(value = 1, "asd"),
                TTMenuInputDropdownItemData(value = 2, "asd")
            ),
            symbol = "$",
            onCurrencyClick = {}
        )
    }
}
