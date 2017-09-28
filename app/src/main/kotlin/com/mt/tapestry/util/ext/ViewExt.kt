package com.mt.tapestry.util.ext

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by max on 10-May-17.
 */

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun View.showHide(active: Boolean) {
    if (active) show() else hide()
}

fun ImageView.load(url: String?) {
    Glide.with(this.context).load(url).into(this)
}