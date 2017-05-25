package com.mt.feedlin.util.ext

import android.view.View
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by max on 10-May-17.
 */

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun ImageView.load(url: String?) {
    Picasso.with(this.context).load(url).into(this)
}