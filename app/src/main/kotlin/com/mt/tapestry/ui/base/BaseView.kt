package com.mt.tapestry.ui.base

/**
 * Created by m_toskhoparan on 08-May-17.
 */

interface BaseView {

    fun showProgress(active: Boolean)

    fun showError()

    fun isActive(): Boolean
}