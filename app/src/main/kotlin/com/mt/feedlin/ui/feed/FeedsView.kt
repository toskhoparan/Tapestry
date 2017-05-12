package com.mt.feedlin.ui.feed

import com.mt.feedlin.data.Feed
import com.mt.feedlin.ui.base.BaseView

/**
 * Created by m_toskhoparan on 08-May-17.
 */

interface FeedsView : BaseView {

    fun showFeeds(feeds: MutableList<Feed>)
}