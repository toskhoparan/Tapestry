package com.mt.feedlin.ui.base.presenter

import com.mt.feedlin.ui.base.state.BaseState
import com.mt.feedlin.ui.base.view.BaseView
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by m_toskhoparan on 09-May-17.
 */

abstract class AbstractPresenter<V : BaseView, S : BaseState> : BaseStatefulPresenter<V, S> {

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
        saveState(state)
        subscriptions?.clear()
    }

    override fun detachView() {
        view = null
        subscriptions = null
        state = null
    }

    abstract fun loadData(refresh: Boolean = false)
    abstract fun saveState(state: S?)
}