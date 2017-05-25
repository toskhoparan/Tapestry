package com.mt.feedlin.util.ext

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale.ENGLISH

/**
 * Created by max on 23-May-17.
 */

fun String.formatDate(input: String, output: String): String {
    val date = SimpleDateFormat(input, ENGLISH).parse(this)
    return SimpleDateFormat(output, ENGLISH).format(date)
}

fun String.toDate(format: String = "EEE, dd MMM yyyy HH:mm:ss Z"): Date {
    return SimpleDateFormat(format, ENGLISH).parse(this)
}