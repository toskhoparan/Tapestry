package com.mt.tapestry.ui.feed

import com.mt.tapestry.data.model.Feed
import com.mt.tapestry.ui.base.navigator.BaseNavigator
import com.mt.tapestry.ui.base.presenter.BaseStatefulPresenter
import com.mt.tapestry.ui.base.state.BaseState
import com.mt.tapestry.ui.base.view.BaseView

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