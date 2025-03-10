package com.extensions

const val EURO = "€"

fun Int.toEurosText() = "$this $EURO"