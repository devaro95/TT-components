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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.ttcomponents.app.R
import com.components.icon.TTIcon
import com.components.styles.InputBorder
import com.components.styles.InputLegend
import com.components.styles.Placeholder
import com.components.styles.Primary
import com.components.styles.SecondaryBackground
import com.vro.constants.EMPTY_STRING

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TTInputDropdown(
    modifier: Modifier = Modifier,
    items: List<TTInputDropdownItemData>,
    placeholder: String = EMPTY_STRING,
    selectedItem: String? = null,
    selectedPosition: Int? = null,
    showBorder: Boolean = true,
    onClick: (() -> Unit)? = null,
) {
    Column(
        modifier = modifier
            .height(56.dp)
            .then(
                if (showBorder) Modifier.border(
                    border = BorderStroke(1.dp, InputBorder),
                    shape = RoundedCornerShape(10.dp)
                )
                else Modifier
            )
            .clip(RoundedCornerShape(10.dp))
            .background(SecondaryBackground)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
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
                            selectedItem ?: placeholder
                        },
                        style = MaterialTheme.typography.bodySmall,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                    )
                }
            }
            Column(modifier = Modifier.padding(end = 16.dp)) {
                TTIcon(
                    iconRes = R.drawable.ic_back,
                    modifier = Modifier.rotate(-90f),
                    onClick = { onClick?.invoke() },
                    tint = InputLegend
                )
            }
        }
    }
}

data class TTInputDropdownItemData(
    val text: String,
)

@Composable
@Preview(backgroundColor = 0xFFFFFFFF)
private fun TTInputDropdownPreview() {
    TTInputDropdown(
        placeholder = "Item Seleccionado",
        items = listOf(
            TTInputDropdownItemData(
                text = "10"
            )
        )
    )
}