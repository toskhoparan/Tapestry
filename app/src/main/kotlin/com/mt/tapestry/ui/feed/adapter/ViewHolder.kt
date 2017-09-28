package com.mt.tapestry.ui.feed.adapter

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.mt.simplerecycler.RecyclerViewHolder
import com.mt.tapestry.data.entity.Feed
import com.mt.tapestry.util.ext.formatDate
import com.mt.tapestry.util.ext.load
import kotlinx.android.synthetic.main.item_feed.view.*

/**
 * Created by m_toskhoparan on 12-May-17.
 */
internal class ViewHolder(val view: View) : RecyclerViewHolder<Feed>(view) {

    val image: ImageView = view.image
    val title: TextView = view.title
    val description: TextView = view.description
    val date: TextView = view.date
    val share: ImageButton = view.share
    val openLink: ImageButton = view.openLink

    override fun bind(item: Feed) {
        image.load(item.url)
        title.text = item.title
        description.text = item.description
        date.text = item.pubDate.formatDate(DATE_INPUT, DATE_OUTPUT)

//        share.setOnClickListener { listener?.let { it(item) } }
//        openLink.setOnClickListener { linkListener?.invoke(item.link) }
    }

    companion object {
        const val DATE_INPUT = "EEE, dd MMM yyyy HH:mm:ss Z"
        const val DATE_OUTPUT = "EEE, dd MMM HH:mm"
    }
}