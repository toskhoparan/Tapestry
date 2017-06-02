package com.mt.feedlin.ui.feed

import com.mt.feedlin.data.model.Feed
import com.mt.feedlin.ui.base.navigator.BaseNavigator
import com.mt.feedlin.ui.base.presenter.BaseStatefulPresenter
import com.mt.feedlin.ui.base.state.BaseState
import com.mt.feedlin.ui.base.view.BaseView

/**
 * Created by max on 23-May-17.
 */

interface FeedsContract {

    interface View : BaseView {
        fun showFeeds(feeds: MutableList<Feed>, position: Int? = 0)
        fun getItemPosition(): Int
    }

    interface Presenter : BaseStatefulPresenter<View, State> {
        fun navigator(): Navigator
    }

    interface Navigator : BaseNavigator {
        fun shareFeed(feed: Feed)
        fun openLink(link: String?)
    }

    interface State : BaseState {
        var itemPosition: Int?
    }
}