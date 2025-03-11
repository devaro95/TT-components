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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ttcomponents.app.R
import com.components.icon.TTIcon
import com.components.styles.InputBorder
import com.components.styles.InputLegend
import com.components.styles.SecondaryBackground
import com.components.text.TTHeaderText14
import com.vro.constants.EMPTY_STRING

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TTInputClickableDropdown(
    modifier: Modifier = Modifier,
    value: String = EMPTY_STRING,
    showBorder: Boolean = true,
    backgroundColor: Color = SecondaryBackground,
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
            .background(backgroundColor)
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
                TTHeaderText14(text = value)
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

@Composable
@Preview(backgroundColor = 0xFFFFFFFF)
private fun TTInputClickableDropdownPreview() {
    TTInputClickableDropdown(
        value = "EUR"
    )
}