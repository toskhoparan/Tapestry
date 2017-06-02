package com.mt.feedlin.ui.base

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by m_toskhoparan on 09-May-17.
 */

abstract class BaseAbstractPresenter<V : BaseView> : BasePresenter<V> {

    var view: V? = null

    var subscriptions: CompositeDisposable? = CompositeDisposable()

    var firstLoad = true
    var dataLoaded = false

    override fun attachView(view: V) {
        this.view = view
    }

    override fun subscribe() {
        loadData()
        if (firstLoad) firstLoad = false
    }

    override fun unsubscribe() {
        subscriptions?.clear()
    }

    override fun detachView() {
        view = null
        subscriptions = null
    }

    abstract fun loadData(refresh: Boolean = false)
}