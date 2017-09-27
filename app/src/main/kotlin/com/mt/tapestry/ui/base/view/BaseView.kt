package com.mt.tapestry.ui.base.view

import android.support.annotation.StringRes

/**
 * Created by m_toskhoparan on 08-May-17.
 */

interface BaseView {

    fun showProgress(active: Boolean)

    fun showEmpty()

    fun showError()

    fun showMessage(@StringRes message: Int)
}