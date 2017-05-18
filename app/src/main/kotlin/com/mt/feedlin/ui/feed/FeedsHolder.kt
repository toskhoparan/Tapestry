package com.mt.feedlin.ui.feed

import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import com.bumptech.glide.Glide
import com.mt.feedlin.R
import com.mt.feedlin.data.Feed
import com.mt.feedlin.util.ClickListener
import com.mt.feedlin.util.date
import kotlinx.android.synthetic.main.item_feed.view.*

/**
 * Created by m_toskhoparan on 12-May-17.
 */

internal class FeedsHolder(val view: View) : ViewHolder(view) {

    companion object {
        const val DATE_INPUT = "EEE, dd MMM yyyy HH:mm:ss Z"
        const val DATE_OUTPUT = "EEE, dd MMM HH:mm"
    }

    fun bind(item: Feed, listener: ClickListener<Feed>) {
        Glide.with(view.context).load(item.url)
                .placeholder(R.drawable.ic_photo)
                .centerCrop().into(view.image)

        view.title.text = item.title
        view.description.text = item.description
        view.date.text = item.pubDate?.date(DATE_INPUT, DATE_OUTPUT)

        view.share.setOnClickListener { listener(item) }
    }
}