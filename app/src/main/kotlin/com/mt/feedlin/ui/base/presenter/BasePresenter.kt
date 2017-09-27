package com.mt.feedlin.ui.base.presenter

import com.mt.feedlin.ui.base.view.BaseView

/**
 * Created by m_toskhoparan on 08-May-17.
 */
interface BasePresenter<in V : BaseView> {

    fun attachView(view: V)

    fun subscribe()

    fun unsubscribe()

    fun detachView()
}