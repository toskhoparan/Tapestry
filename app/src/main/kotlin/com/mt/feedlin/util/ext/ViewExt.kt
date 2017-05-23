package com.mt.feedlin.util.ext

import android.view.View
import android.widget.ImageView
import com.mt.feedlin.R
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

fun ImageView.load(url: String?, ph: Int = R.drawable.ic_photo) {
    Picasso.with(this.context).load(url).placeholder(ph).into(this)
}