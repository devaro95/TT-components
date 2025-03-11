package com.components.input

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ttcomponents.app.R
import com.components.icon.TTIcon
import com.components.styles.InputBorder
import com.components.styles.Placeholder
import com.components.styles.Primary
import com.components.styles.SecondaryBackground
import com.vro.constants.EMPTY_STRING

@Composable
fun TTInputDate(
    modifier: Modifier = Modifier,
    firstValue: String?,
    secondValue: String?,
    onFirstClick: () -> Unit,
    onSecondClick: () -> Unit,
) {
    Row(
        modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .clip(RoundedCornerShape(8.dp))
            .background(SecondaryBackground)
            .border(1.dp, InputBorder, RoundedCornerShape(8.dp))
    ) {
        Column(
            Modifier
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = onFirstClick,
                )
                .fillMaxWidth()
                .weight(1f)
        ) {
            TTInputDateTextField(
                value = firstValue.orEmpty(),
                placeholder = stringResource(R.string.input_date_departure),
                shape = RoundedCornerShape(
                    topStart = 8.dp,
                    bottomStart = 8.dp
                )
            )
        }
        VerticalDivider(
            modifier = Modifier.padding(vertical = 16.dp),
            color = Primary
        )
        Column(
            Modifier
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = onSecondClick,
                )
                .fillMaxWidth()
                .weight(1f)
        ) {
            TTInputDateTextField(
                value = secondValue.orEmpty(),
                placeholder = stringResource(R.string.input_date_arrival),
                shape = RoundedCornerShape(
                    topEnd = 8.dp,
                    bottomEnd = 8.dp
                )
            )
        }
    }
}

@Composable
private fun TTInputDateTextField(
    value: String,
    placeholder: String,
    shape: Shape,
    startIcon: Int? = null,
) {
    TextField(
        colors = TextFieldDefaults.colors(
            focusedContainerColor = SecondaryBackground,
            unfocusedContainerColor = SecondaryBackground,
            disabledContainerColor = SecondaryBackground,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        enabled = false,
        value = value,
        onValueChange = { },
        shape = shape,
        leadingIcon = startIcon?.let { { TTIcon(iconRes = it) } },
        singleLine = true,
        maxLines = 1,
        minLines = 1,
        textStyle = MaterialTheme.typography.headlineMedium,
        label = {
            Text(
                text = placeholder,
                minLines = 1,
                style = MaterialTheme.typography.bodyMedium,
                overflow = TextOverflow.Ellipsis,
                color = Placeholder
            )
        }
    )
}

@Composable
@Preview(backgroundColor = 0xFFFFFFFF)
fun TTInputDateDatePreview() {
    Column {
        TTInputDate(
            firstValue = EMPTY_STRING,
            secondValue = "18/11/2024",
            onFirstClick = {},
            onSecondClick = {}
        )
    }
}