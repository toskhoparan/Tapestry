package com.mt.tapestry.ui.base.view

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.mt.tapestry.TapestryApp
import com.mt.tapestry.injection.app.ApplicationComponent
import com.mt.tapestry.ui.base.state.BaseState
import com.mt.tapestry.ui.base.presenter.BaseStatefulPresenter

/**
 * Created by m_toskhoparan on 08-May-17.
 */

abstract class BaseActivity<in V : BaseView,
    P : BaseStatefulPresenter<V, S>, S : BaseState> : AppCompatActivity(), BaseView {

    companion object {
        const val STATE_KEY = "STATE_KEY"
    }

    abstract var layoutID: Int
    abstract fun setupComponent(component: ApplicationComponent)
    abstract var presenter: P
    abstract fun setupViews()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutID)

        setupComponent((application as TapestryApp).applicationComponent)
        presenter.attachView(this as V)

        setupViews()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(STATE_KEY, presenter.state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        presenter.state = savedInstanceState?.getParcelable(STATE_KEY)
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