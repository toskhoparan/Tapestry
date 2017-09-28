package com.mt.tapestry.ui.feed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mt.simplerecycler.RecyclerViewHolder
import com.mt.tapestry.R
import com.mt.tapestry.data.entity.Feed

/**
 * Created by m_toskhoparan on 09/28/17.
 */
class ViewHolderFactory : RecyclerViewHolder.Factory<Feed> {

    override fun get(parent: ViewGroup, viewType: Int): RecyclerViewHolder<Feed> =
            ViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_feed, parent, false))

    override fun getViewType(item: Feed?, position: Int) = 0
}