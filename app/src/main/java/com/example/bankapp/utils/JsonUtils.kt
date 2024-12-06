package com.example.bankapp.utils

import android.content.Context
import java.io.IOException

fun readJsonFromAssets(context: Context, fileName: String): String {
    return try {
        context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        throw IOException("Error reading $fileName", ioException)
    }
}