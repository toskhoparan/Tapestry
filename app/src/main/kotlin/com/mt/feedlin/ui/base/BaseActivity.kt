package com.mt.feedlin.ui.base

import android.app.Activity
import android.os.Bundle
import android.support.design.widget.Snackbar
import com.mt.feedlin.FeedlinApplication
import com.mt.feedlin.injection.app.ApplicationComponent

/**
 * Created by m_toskhoparan on 08-May-17.
 */

abstract class BaseActivity<in V : BaseView, P : BasePresenter<V>> : Activity(), BaseView {

    abstract var layoutID: Int
    abstract fun setupComponent(component: ApplicationComponent)
    abstract var presenter: P
    abstract fun setupViews()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutID)

        setupComponent((application as FeedlinApplication).applicationComponent)
        presenter.attachView(this as V)

        setupViews()
    }

    override fun onResume() {
        super.onResume()
        presenter.subscribe()
    }

    override fun onPause() {
        super.onPause()
        presenter.unsubscribe()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun showMessage(message: Int) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show()
    }
}