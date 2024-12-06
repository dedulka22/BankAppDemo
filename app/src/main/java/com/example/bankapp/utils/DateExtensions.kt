package com.example.bankapp.utils

import java.text.SimpleDateFormat
import java.util.Locale

fun String.formatDateString(
    inputPattern: String = "yyyy-MM-dd'T'HH:mm:ss",
    outputPattern: String = "dd.MM.yyyy"
): String {
    return try {
        val inputFormatter = SimpleDateFormat(inputPattern, Locale.getDefault())
        val outputFormatter = SimpleDateFormat(outputPattern, Locale.getDefault())
        val date = inputFormatter.parse(this)
        date?.let { outputFormatter.format(it) } ?: this
    } catch (e: Exception) {
        this
    }
}