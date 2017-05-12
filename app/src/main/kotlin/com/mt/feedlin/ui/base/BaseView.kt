package com.mt.feedlin.ui.base

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