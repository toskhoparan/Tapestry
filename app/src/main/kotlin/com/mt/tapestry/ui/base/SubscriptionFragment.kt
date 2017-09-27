package com.mt.tapestry.ui.base

import android.os.Bundle
import android.view.View

/**
 * Created by m_toskhoparan on 09/27/17.
 */
abstract class SubscriptionFragment<in V : BaseView, P : BasePresenter<V>> : BaseFragment(), BaseView {

    protected abstract var presenter: P

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this as V)
    }

    override fun onResume() {
        super.onResume()
        presenter.subscribe()
    }

    override fun onPause() {
        super.onPause()
        presenter.unsubscribe()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }
}