@file:JvmName("TTInputKt")

package com.components.input

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.ttcomponents.app.R
import com.components.icon.TTIcon
import com.components.input.InputType.FULL
import com.components.styles.InputBorder
import com.components.styles.Placeholder
import com.components.styles.Primary
import com.components.styles.SecondaryBackground
import com.components.text.TTErrorText
import com.components.text.TTHeaderText18
import com.components.text.TTLegendText
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING
import com.vro.constants.INT_ZERO

@Composable
fun TTInput(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String? = null,
    startIcon: Int? = null,
    minLines: Int = 1,
    maxLength: Int? = null,
    showCharCounter: Boolean = false,
    minLength: Int = INT_ZERO,
    containerColor: Color = SecondaryBackground,
    keyboardType: KeyboardType = KeyboardType.Text,
    suffix: String? = null,
    inputType: InputType = FULL,
    errorText: String = EMPTY_STRING,
    isError: Boolean = false,
    imeAction: ImeAction = ImeAction.Unspecified,
    showBorder: Boolean = true,
    onChange: (String) -> Unit,
) {
    Column(modifier = modifier) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .then(
                    if (showBorder) Modifier.border(
                        width = 1.dp,
                        color = if (isError) MaterialTheme.colorScheme.error else InputBorder,
                        shape = RoundedCornerShape(8.dp)
                    )
                    else Modifier
                ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = containerColor,
                unfocusedContainerColor = containerColor,
                disabledContainerColor = containerColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                errorTextColor = MaterialTheme.colorScheme.error,
                errorContainerColor = containerColor
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
            label = placeholder?.let {
                {
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
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            suffix = suffix?.let {
                { TTHeaderText18(text = it) }
            },
            isError = isError
        )
        if (showCharCounter) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                if (value.length - minLength < INT_ZERO) {
                    TTErrorText(text = (value.length - minLength).toString())
                    TTLegendText(text = "/${maxLength}")
                } else {
                    TTLegendText(
                        text = (value.length - minLength).toString() + "/" + maxLength.toString(),
                    )
                }
            }
        }
        if (isError) {
            TTErrorText(
                modifier = Modifier.padding(top = 4.dp),
                text = errorText,
            )
        }
    }
}

@Composable
@VROLightMultiDevicePreview
private fun TTInputNewPreview() {
    Column {
        TTInput(
            value = EMPTY_STRING,
            placeholder = "Input",
            onChange = {}
        )
        TTInput(
            value = "Value",
            onChange = {}
        )
        TTInput(
            modifier = Modifier.padding(top = 8.dp),
            value = EMPTY_STRING,
            placeholder = "Input",
            onChange = {}
        )
        TTInput(
            modifier = Modifier.padding(top = 8.dp),
            value = "value",
            placeholder = "Input",
            onChange = {}
        )
        TTInput(
            modifier = Modifier.padding(top = 8.dp),
            value = EMPTY_STRING,
            minLength = 10,
            maxLength = 100,
            placeholder = "Counter Input",
            showCharCounter = true,
            onChange = {}
        )
        TTInput(
            modifier = Modifier.padding(top = 8.dp),
            value = EMPTY_STRING,
            minLength = 10,
            maxLength = 100,
            placeholder = "Counter Input",
            onChange = {},
            isError = true,
            errorText = "Error"
        )
    }
}
