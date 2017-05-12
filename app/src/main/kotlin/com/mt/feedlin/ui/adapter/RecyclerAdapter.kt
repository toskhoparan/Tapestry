package com.mt.feedlin.ui.adapter

import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mt.feedlin.util.Binder

/**
 * Created by m_toskhoparan on 11-May-17.
 */

class RecyclerAdapter<VH : ViewHolder, E>
constructor(val vhClass: Class<VH>,
            val layoutRes: Int,
            var bind: Binder<VH, E>,
            var items: MutableList<E> = ArrayList()) : Adapter<VH>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VH {
        val view: View = LayoutInflater.from(parent?.context).inflate(layoutRes, parent, false)
        return vhClass.getConstructor(View::class.java).newInstance(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) = bind(holder, items[position])

    override fun getItemCount() = items.size

    override fun getItemId(position: Int)
            = items[position]?.hashCode()?.toLong() ?: super.getItemId(position)
}
