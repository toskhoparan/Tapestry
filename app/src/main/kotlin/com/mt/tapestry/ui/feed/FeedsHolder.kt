package com.mt.tapestry.ui.feed

import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import com.mt.tapestry.data.entity.Feed
import com.mt.tapestry.util.ClickListener
import com.mt.tapestry.util.ext.formatDate
import com.mt.tapestry.util.ext.load
import kotlinx.android.synthetic.main.item_feed.view.*

/**
 * Created by m_toskhoparan on 12-May-17.
 */

class FeedsHolder(val view: View) : ViewHolder(view) {

    companion object {
        const val DATE_INPUT = "EEE, dd MMM yyyy HH:mm:ss Z"
        const val DATE_OUTPUT = "EEE, dd MMM HH:mm"
    }

    fun bind(item: Feed,
             listener: ClickListener<Feed>? = null,
             linkListener: ClickListener<String?>? = null) {

        view.image.load(item.url)
        view.title.text = item.title
        view.description.text = item.description
        view.date.text = item.pubDate.formatDate(DATE_INPUT, DATE_OUTPUT)

        view.share.setOnClickListener { listener?.let { it(item) } }
        view.openLink.setOnClickListener { linkListener?.invoke(item.link) }
    }
}