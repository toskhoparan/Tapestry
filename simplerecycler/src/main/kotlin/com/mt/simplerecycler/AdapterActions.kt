package com.mt.simplerecycler

/**
 * Created by m_toskhoparan on 09/21/17.
 */

interface AdapterActions<E> {

    fun add(item: E)

    fun addAll(items: MutableList<E>)

    fun remove(item: E)

    fun removeAll()
}
