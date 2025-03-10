package com.components.picker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.R
import com.components.styles.Background
import com.components.styles.Placeholder
import com.components.styles.Primary
import com.components.styles.Secondary
import com.components.styles.White
import com.components.text.TTHeaderText16
import com.components.text.TTHeaderText30
import com.extensions.DATE_FORMAT_MONTH_CHAR
import com.extensions.time
import com.extensions.toLocalDate
import com.extensions.toString
import com.vro.compose.preview.VROLightMultiDevicePreview
import java.time.LocalDate
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TTDatePicker(
    selectedDate: Long = Date().time,
    title: String,
    onConfirm: (Long) -> Unit,
    onCancel: () -> Unit,
    startSelectableDate: Long? = null,
) {
    val state = rememberDatePickerState(
        initialSelectedDateMillis = selectedDate,
        yearRange = IntRange(LocalDate.now().year.dec(), LocalDate.now().year.inc()),
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                return utcTimeMillis >= (startSelectableDate ?: LocalDate.now().atStartOfDay()
                    .time())
                        && utcTimeMillis <= LocalDate.now().plusYears(1).atStartOfDay().time()
            }

            override fun isSelectableYear(year: Int): Boolean {
                return year <= LocalDate.now().year.inc()
            }
        }
    )
    Column(
        modifier = Modifier
    ) {
        DatePickerDialog(
            modifier = Modifier
                .scale(0.9f)
                .padding(vertical = 16.dp),
            onDismissRequest = { },
            confirmButton = {
                Row(modifier = Modifier.padding(end = 16.dp, bottom = 8.dp)) {
                    DatePickerButton(
                        text = stringResource(R.string.accept),
                        textColor = Color.White,
                        containerColor = Secondary,
                        onClick = { state.selectedDateMillis?.let { onConfirm(it) } }
                    )
                }
            },
            dismissButton = {
                Row(modifier = Modifier.padding(bottom = 8.dp)) {
                    DatePickerButton(
                        text = stringResource(R.string.cancel),
                        textColor = Primary,
                        containerColor = Background,
                        onClick = onCancel
                    )
                }
            },
            colors = DatePickerDefaults.colors(
                selectedDayContentColor = Color.White,
                dividerColor = Color.White,
                yearContentColor = Secondary,
                selectedYearContentColor = Color.White,
                selectedYearContainerColor = Secondary,
                containerColor = Background,
                disabledDayContentColor = Color(0xFFD6D6D6),
                dayContentColor = Primary,
                weekdayContentColor = Secondary,
                todayContentColor = Primary,
                navigationContentColor = Primary,
            )
        ) {
            DatePicker(
                modifier = Modifier.navigationBarsPadding(),
                state = state,
                title = {
                    TTHeaderText16(
                        modifier = Modifier.padding(start = 24.dp, top = 24.dp),
                        text = title
                    )
                },
                colors = DatePickerDefaults.colors(
                    selectedDayContentColor = Color.White,
                    dividerColor = Background,
                    yearContentColor = White,
                    selectedYearContentColor = Background,
                    selectedYearContainerColor = White,
                    containerColor = Background,
                    disabledDayContentColor = Placeholder,
                    dayContentColor = Primary,
                    weekdayContentColor = White,
                    todayContentColor = Primary,
                    navigationContentColor = Primary,
                ),
                headline = {
                    TTHeaderText30(
                        modifier = Modifier.padding(horizontal = 24.dp),
                        text = state.selectedDateMillis?.toLocalDate()
                            ?.toString(DATE_FORMAT_MONTH_CHAR)
                            .orEmpty(),
                        color = White
                    )
                },
                showModeToggle = false
            )
        }
    }
}

@Composable
fun DatePickerButton(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color,
    containerColor: Color,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(containerColor = containerColor),
        shape = CircleShape.copy(CornerSize(10.dp)),
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            color = textColor
        )
    }
}

@VROLightMultiDevicePreview
@Composable
private fun TTDatePickerPreview() {
    TTDatePicker(
        title = "Selecciona una fecha",
        onConfirm = {},
        onCancel = {}
    )
}