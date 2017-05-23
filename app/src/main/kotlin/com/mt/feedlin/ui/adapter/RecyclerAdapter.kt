package com.mt.feedlin.ui.adapter

import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mt.feedlin.util.Binder
import javax.inject.Inject

/**
 * Created by m_toskhoparan on 11-May-17.
 */

class RecyclerAdapter<VH : ViewHolder, E>
@Inject constructor(val vhClass: Class<VH>) : Adapter<VH>() {

    var layoutRes: Int? = null
    var binder: Binder<VH, E>? = null
    var items: MutableList<E> = ArrayList()

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VH {
        val view: View = LayoutInflater.from(parent?.context).inflate(layoutRes!!, parent, false)
        return vhClass.getConstructor(View::class.java).newInstance(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        binder?.invoke(holder, items[position])
    }

    override fun getItemCount() = items.size

    override fun getItemId(position: Int)
            = items[position]?.hashCode()?.toLong() ?: super.getItemId(position)
}
