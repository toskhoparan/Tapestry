package com.mt.tapestry.ui.feed

import com.mt.tapestry.R
import com.mt.tapestry.data.entity.Feed
import com.mt.tapestry.ui.adapter.RecyclerAdapter
import com.mt.tapestry.ui.base.SubscriptionFragment
import com.mt.tapestry.ui.navigator.MainNavigator
import com.mt.tapestry.util.ext.hide
import com.mt.tapestry.util.ext.show
import kotlinx.android.synthetic.main.fragment_feeds.*
import javax.inject.Inject

/**
 * Created by m_toskhoparan on 09/27/17.
 */
class FeedsFragment : SubscriptionFragment<FeedsContract.View, FeedsContract.Presenter>(), FeedsContract.View {

    override var layout = R.layout.fragment_feeds

    @Inject override lateinit var presenter: FeedsContract.Presenter
    @Inject lateinit var navigator: MainNavigator
    @Inject lateinit var adapter: RecyclerAdapter<FeedsHolder, Feed>

    override fun setupViews() {
        adapter.apply {
            layoutRes = R.layout.item_feed
            binder = { holder, feed -> holder.bind(feed,
                    { navigator.shareFeed(feed) },
                    { navigator.openLink(feed.link)}) }
        }

        recyclerFeeds.setHasFixedSize(true)
        recyclerFeeds.adapter = adapter
    }

    override fun showFeeds(feeds: MutableList<Feed>) {
        hide(empty, error)
        recyclerFeeds.show()
        adapter.items = feeds
    }

    override fun showNoFeeds() {
        hide(error, recyclerFeeds)
        empty.show()
    }

    override fun showProgress(active: Boolean) {
        if (active) progress.show() else progress.hide()
    }

    override fun showError() {
        hide(empty, recyclerFeeds)
        error.show()
    }

    override fun isActive() = isAdded

    companion object {
        fun newInstance() = FeedsFragment()
    }
}