package com.mt.tapestry.ui.adapter

import android.support.v7.util.DiffUtil

/**
 * Created by max on 02-Jun-17.
 */
class DiffCallback<T> : DiffUtil.Callback() {

    var oldItems: MutableList<T> = ArrayList()
    var newItems: MutableList<T> = ArrayList()

    override fun getOldListSize() = oldItems.size

    override fun getNewListSize() = newItems.size

    override fun areItemsTheSame(oldPosition: Int, newPosition: Int)
            = oldItems[oldPosition] == newItems[newPosition]

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int) = true
}