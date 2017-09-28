package com.mt.tapestry.ui.feed.adapter

import com.mt.simplerecycler.RecyclerAdapter
import com.mt.simplerecycler.RecyclerViewHolder
import com.mt.tapestry.data.entity.Feed
import javax.inject.Inject

/**
 * Created by m_toskhoparan on 09/28/17.
 */
class FeedsAdapter
    @Inject constructor(override val factory: RecyclerViewHolder.Factory<Feed>) : RecyclerAdapter<Feed>() {

    override fun areItemsTheSame(oldItem: Feed, newItem: Feed) = oldItem == newItem

    override fun areContentsTheSame(oldItem: Feed, newItem: Feed) =
            (oldItem.title == newItem.title
                    && oldItem.description == newItem.description
                    && oldItem.pubDate == newItem.pubDate
                    && oldItem.link == newItem.link)
}