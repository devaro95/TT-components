package com.components.input

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.R
import com.components.styles.InputBorder
import com.components.styles.Placeholder
import com.components.styles.Primary
import com.components.styles.SecondaryBackground
import com.components.text.TTErrorText
import com.components.text.TTHeaderText18
import com.vro.compose.preview.VROLightMultiDevicePreview
import com.vro.constants.EMPTY_STRING

@Composable
fun TTPasswordInput(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String = EMPTY_STRING,
    minLines: Int = 1,
    containerColor: Color = SecondaryBackground,
    suffix: String? = null,
    errorText: String = EMPTY_STRING,
    isError: Boolean = false,
    imeAction: ImeAction = ImeAction.Unspecified,
    onChange: (String) -> Unit,
) {

    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    Column(modifier = modifier) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = if (isError) MaterialTheme.colorScheme.error else InputBorder,
                    shape = RoundedCornerShape(8.dp)
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
            onValueChange = onChange,
            shape = CircleShape.copy(CornerSize(8.dp)),
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
                keyboardType = KeyboardType.Password,
                imeAction = imeAction
            ),
            suffix = suffix?.let {
                { TTHeaderText18(text = it) }
            },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        if (passwordVisible) Icons.Filled.Visibility
                        else Icons.Filled.VisibilityOff,
                        contentDescription = null
                    )
                }
            },
            isError = isError
        )
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
private fun TTPasswordInputNewPreview() {
    Column {
        TTPasswordInput(
            value = EMPTY_STRING,
            placeholder = "Input",
            onChange = {}
        )
        TTPasswordInput(
            modifier = Modifier.padding(top = 8.dp),
            value = EMPTY_STRING,
            placeholder = "Input",
            onChange = {}
        )
        TTPasswordInput(
            modifier = Modifier.padding(top = 8.dp),
            value = "value",
            placeholder = "Input",
            onChange = {}
        )
        TTPasswordInput(
            modifier = Modifier.padding(top = 8.dp),
            value = EMPTY_STRING,
            placeholder = "Counter Input",
            onChange = {}
        )
    }
}
