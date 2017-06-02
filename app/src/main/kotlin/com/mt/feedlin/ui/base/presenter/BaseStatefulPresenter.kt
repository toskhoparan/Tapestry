package com.mt.feedlin.ui.base.presenter

import com.mt.feedlin.ui.base.state.BaseState
import com.mt.feedlin.ui.base.view.BaseView

/**
 * Created by max on 02-Jun-17.
 */

interface BaseStatefulPresenter<in V : BaseView, S : BaseState> : BasePresenter<V> {
    var state: S?
}