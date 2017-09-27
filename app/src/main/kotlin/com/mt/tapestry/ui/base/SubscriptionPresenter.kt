package com.mt.tapestry.ui.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by m_toskhoparan on 09/27/17.
 */
abstract class SubscriptionPresenter<V : BaseView> : BasePresenter<V> {

    protected var view: V? = null
    private var subscriptions: CompositeDisposable? = CompositeDisposable()

    override fun attachView(view: V) {
        this.view = view
        onViewAttached()
    }

    override fun subscribe() {
        onSubscribed()
    }

    override fun unsubscribe() {
        subscriptions?.clear()
        onUnsubscribed()
    }

    override fun detachView() {
        view = null
        subscriptions = null
        onViewDetached()
    }

    protected fun doSubscribe(subscription: Disposable) {
        subscriptions?.add(subscription)
    }

    protected open fun onViewAttached() {}
    protected open fun onSubscribed() {}
    protected open fun onUnsubscribed() {}
    protected open fun onViewDetached() {}
}