package com.mt.feedlin.util.ext

import android.os.Parcel
import android.os.Parcelable
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

// Inline function to create Parcel Creator
inline fun <reified T : Parcelable> createParcel(
    crossinline createFromParcel: (Parcel) -> T?): Parcelable.Creator<T> =
    object : Parcelable.Creator<T> {
        override fun createFromParcel(source: Parcel): T? = createFromParcel(source)
        override fun newArray(size: Int): Array<out T?> = arrayOfNulls(size)
    }