package com.mt.simplerecycler

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

/**
 * Created by m_toskhoparan on 09/21/17.
 */

abstract class RecyclerViewHolder<E>(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bind(item: E)

    interface Factory<E> {

        operator fun get(parent: ViewGroup, viewType: Int): RecyclerViewHolder<E>

        fun getViewType(item: E?, position: Int): Int
    }
}
