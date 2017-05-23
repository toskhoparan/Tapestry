package com.mt.feedlin.ui.feed

import com.mt.feedlin.data.Feed
import com.mt.feedlin.ui.base.BaseNavigator
import com.mt.feedlin.ui.base.BasePresenter
import com.mt.feedlin.ui.base.BaseView

/**
 * Created by max on 23-May-17.
 */

interface FeedsContract {

    interface View : BaseView {
        fun showFeeds(feeds: MutableList<Feed>)
    }

    interface Presenter : BasePresenter<View> {
        fun navigator(): Navigator
    }

    interface Navigator : BaseNavigator {
        fun shareFeed(feed: Feed)
    }
}