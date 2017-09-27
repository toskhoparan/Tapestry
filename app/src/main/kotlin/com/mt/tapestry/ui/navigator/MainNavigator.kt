package com.mt.tapestry.ui.navigator

import com.mt.tapestry.data.entity.Feed

/**
 * Created by m_toskhoparan on 09/27/17.
 */
interface MainNavigator {
    fun navigateToFeeds()
    fun shareFeed(feed: Feed)
    fun openLink(link: String?)
}