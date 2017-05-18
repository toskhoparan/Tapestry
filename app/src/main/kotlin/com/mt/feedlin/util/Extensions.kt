package com.mt.feedlin.util

import android.view.View
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.Locale.ENGLISH

/**
 * Created by max on 10-May-17.
 */

fun <T> Flowable<T>.io(): Flowable<T> {
    return subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun String.date(input: String, output: String): String {
    val date = SimpleDateFormat(input, ENGLISH).parse(this)
    return SimpleDateFormat(output, ENGLISH).format(date)
}