package com.mt.feedlin.ui.base

/**
 * Created by m_toskhoparan on 08-May-17.
 */
interface BasePresenter<in V : BaseView> {

    fun attachView(view: V)

    fun subscribe()

    fun unsubscribe()

    fun detachView()
}