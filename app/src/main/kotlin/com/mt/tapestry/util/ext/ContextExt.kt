package com.mt.tapestry.util.ext

import android.support.v4.app.Fragment
import android.view.View

/**
 * Created by m_toskhoparan on 09/27/17.
 */

fun <T : Fragment> T.show(vararg views: View) {
    views.forEach { it.show() }
}

fun <T : Fragment> T.hide(vararg views: View) {
    views.forEach { it.hide() }
}