package com.mt.tapestry.ui.feed

import com.mt.tapestry.data.entity.Feed
import com.mt.tapestry.ui.base.BasePresenter
import com.mt.tapestry.ui.base.BaseView

/**
 * Created by max on 23-May-17.
 */

interface FeedsContract {

    interface View : BaseView {
        fun showFeeds(feeds: MutableList<Feed>)
        fun showNoFeeds()
    }

    interface Presenter : BasePresenter<View> {
        fun loadFeeds(refresh: Boolean = true)
    }
}