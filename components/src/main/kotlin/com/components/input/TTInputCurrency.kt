package com.components.input

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.components.input.InputType.DIGITS
import com.components.styles.SecondaryBackground
import com.vro.constants.EMPTY_STRING

@Composable
fun TTInputCurrency(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String = EMPTY_STRING,
    startIcon: Int? = null,
    maxLength: Int? = null,
    containerColor: Color = SecondaryBackground,
    currency: String,
    onChange: (String) -> Unit,
) {
    TTInput(
        modifier = modifier,
        value = value,
        placeholder = placeholder,
        startIcon = startIcon,
        maxLength = maxLength,
        containerColor = containerColor,
        keyboardType = KeyboardType.NumberPassword,
        suffix = currency,
        inputType = DIGITS,
        onChange = onChange
    )
}

@Composable
@Preview(backgroundColor = 0xFFFFFFFF)
private fun TTInputCurrencyPreview() {
    Column {
        TTInputCurrency(
            value = EMPTY_STRING,
            placeholder = "Input",
            currency = "€",
            onChange = {}
        )
        TTInputCurrency(
            value = EMPTY_STRING,
            placeholder = "Input",
            currency = "€",
            onChange = {}
        )
        TTInputCurrency(
            value = "value",
            placeholder = "Input",
            currency = "€",
            onChange = {}
        )
        TTInputCurrency(
            value = EMPTY_STRING,
            placeholder = "Counter Input",
            currency = "€",
            onChange = {}
        )
    }
}
