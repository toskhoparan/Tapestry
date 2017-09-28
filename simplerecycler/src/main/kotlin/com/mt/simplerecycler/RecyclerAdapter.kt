package com.mt.simplerecycler

import android.os.AsyncTask
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

import java.util.Collections

/**
 * Created by m_toskhoparan on 09/21/17.
 */

abstract class RecyclerAdapter<E : AdapterItem> : RecyclerView.Adapter<RecyclerViewHolder<E>>(), AdapterActions<E> {

    protected var items: MutableList<E>? = null

    // each time data is set, we update this variable so that if DiffUtil calculation returns
    // after repetitive updates, we can ignore the old calculation
    private var dataVersion = 0

    protected abstract val factory: RecyclerViewHolder.Factory<E>
    protected abstract fun areItemsTheSame(oldItem: E, newItem: E): Boolean
    protected abstract fun areContentsTheSame(oldItem: E, newItem: E): Boolean

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            factory[parent, viewType]

    override fun onBindViewHolder(holder: RecyclerViewHolder<E>, position: Int) {
        items?.let { holder.bind(it[position]) }
    }

    override fun getItemCount() = items?.size ?: 0

    override fun getItemViewType(position: Int)
            = factory.getViewType(items?.get(position), position)

    override fun add(item: E) {
        dataVersion++
        if (items == null) {
            items = mutableListOf(item)
            notifyDataSetChanged()
        } else {
            DiffTask<E>(this, dataVersion, items, mutableListOf(item)).execute()
        }
    }

    override fun addAll(items: MutableList<E>) {
        dataVersion++
        if (this.items == null) {
            this.items = items
            notifyDataSetChanged()
        } else {
            DiffTask<E>(this, dataVersion, this.items, items).execute()
        }
    }

    override fun remove(item: E) {
        dataVersion++
        items?.let {
            val position = it.indexOf(item)
            it.removeAt(position)
            if (it.isEmpty()) items = null
            notifyItemRemoved(position)
        }
    }

    override fun removeAll() {
        dataVersion++
        items?.let {
            val oldSize = it.size
            items = null
            notifyItemRangeRemoved(0, oldSize)
        }
    }

    private class DiffTask<E : AdapterItem>
    internal constructor(private val adapter: RecyclerAdapter<E>,
                         private val currentDataVersion: Int,
                         private val oldItems: MutableList<E>?,
                         private val newItems: MutableList<E>) : AsyncTask<Void, Void, DiffUtil.DiffResult>() {

        override fun doInBackground(vararg voids: Void): DiffUtil.DiffResult {
            return DiffUtil.calculateDiff(object : DiffUtil.Callback() {
                override fun getOldListSize() = oldItems?.size ?: 0

                override fun getNewListSize() = newItems.size

                override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    if (oldItems == null) return false
                    return adapter.areItemsTheSame(oldItems[oldItemPosition], newItems[newItemPosition])
                }

                override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    if (oldItems == null) return false
                    return adapter.areContentsTheSame(oldItems[oldItemPosition], newItems[newItemPosition])
                }
            })
        }

        override fun onPostExecute(diffResult: DiffUtil.DiffResult) {
            if (adapter.dataVersion != currentDataVersion) return
            adapter.items = newItems
            diffResult.dispatchUpdatesTo(adapter)
        }
    }
}
