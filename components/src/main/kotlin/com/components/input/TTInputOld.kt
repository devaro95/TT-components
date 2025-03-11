package com.components.input

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.ttcomponents.app.R
import com.components.icon.TTIcon
import com.components.input.InputType.DIGITS
import com.components.input.InputType.FULL
import com.components.styles.Placeholder
import com.components.styles.Primary
import com.components.styles.Secondary
import com.components.text.TTBodyText14
import com.components.text.TTBodyText14Bold
import com.components.text.TTErrorText
import com.components.text.TTHeaderText18
import com.vro.constants.EMPTY_STRING
import com.vro.constants.INT_ZERO

@Composable
fun TTInputOld(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String = EMPTY_STRING,
    startIcon: Int? = null,
    minLines: Int = 1,
    maxLength: Int? = null,
    showCharCounter: Boolean = false,
    minLength: Int = INT_ZERO,
    containerColor: Color = Color.Transparent,
    keyboardType: KeyboardType = KeyboardType.Text,
    suffix: String? = null,
    inputType: InputType = FULL,
    onChange: (String) -> Unit,
) {
    Column(modifier = modifier) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = containerColor,
                unfocusedContainerColor = containerColor,
                disabledContainerColor = containerColor,
                focusedBorderColor = Secondary,
                unfocusedBorderColor = Secondary
            ),
            value = value,
            onValueChange = {
                if (inputType == FULL || it.isDigitsOnly()) {
                    maxLength?.let { maxLength ->
                        if (it.length <= maxLength) onChange.invoke(it)
                    } ?: onChange.invoke(it)
                }
            },
            shape = CircleShape.copy(CornerSize(8.dp)),
            leadingIcon = startIcon?.let {
                {
                    TTIcon(iconRes = it)
                }
            },
            singleLine = minLines == 1,
            minLines = minLines,
            textStyle = MaterialTheme.typography.bodyMedium,
            label = {
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
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            suffix = suffix?.let {
                { TTHeaderText18(text = it) }
            }
        )
        if (showCharCounter) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                if (value.length - minLength < INT_ZERO) {
                    TTErrorText(text = (value.length - minLength).toString())
                    TTBodyText14Bold(text = "/$maxLength")
                } else {
                    TTBodyText14(
                        text = (value.length - minLength).toString() + "/" + maxLength.toString(),
                    )
                }
            }
        }
    }
}

enum class InputType {
    DIGITS, FULL
}

@Composable
@Preview(backgroundColor = 0xFFFFFFFF)
private fun TTInputPreview() {
    Column {
        TTInputOld(
            value = EMPTY_STRING,
            placeholder = "Input",
            onChange = {}
        )
        TTInputOld(
            value = EMPTY_STRING,
            placeholder = "Input",
            onChange = {}
        )
        TTInputOld(
            value = "value",
            placeholder = "Input",
            onChange = {}
        )
        TTInputOld(
            value = EMPTY_STRING,
            minLength = 10,
            maxLength = 100,
            placeholder = "Counter Input",
            onChange = {}
        )
    }
}