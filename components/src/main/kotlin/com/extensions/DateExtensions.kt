package com.extensions

import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale
import java.util.TimeZone

const val DATE_FORMAT_BAR = "dd/MM/yyyy"
const val DATE_FORMAT_MONTH_CHAR = "dd MMMM yyyy"
const val FULL_SERVICE_DATE = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"

fun String.toDate(inputFormat: String, inputTimeZone: String? = null): Date? =
    kotlin.runCatching {
        SimpleDateFormat(inputFormat, Locale.getDefault()).also { simpleDateFormat ->
            simpleDateFormat.timeZone =
                inputTimeZone?.let { TimeZone.getTimeZone(inputTimeZone) } ?: TimeZone.getDefault()
        }.parse(this)
    }.onFailure { }.getOrNull()

fun String.changeDateFormat(patter: String): String? {
    val utcDateTime = ZonedDateTime.parse(this)
    val localDateTime = utcDateTime.withZoneSameInstant(ZoneId.systemDefault())
    val formatter = DateTimeFormatter.ofPattern(patter)
    return localDateTime.format(formatter)
}

fun LocalDate.toString(pattern: String): String =
    DateTimeFormatter.ofPattern(pattern, Locale.getDefault()).format(this)

fun Long.toLocalDate(): LocalDate =
    Instant.ofEpochMilli(this).atZone(ZoneId.systemDefault()).toLocalDate();

fun LocalDateTime.time() = toInstant(ZoneOffset.UTC).toEpochMilli()