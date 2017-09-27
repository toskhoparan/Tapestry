package com.mt.tapestry.ui.base.presenter

import com.mt.tapestry.ui.base.state.BaseState
import com.mt.tapestry.ui.base.view.BaseView

/**
 * Created by max on 02-Jun-17.
 */

interface BaseStatefulPresenter<in V : BaseView, S : BaseState> : BasePresenter<V> {
    var state: S?
}