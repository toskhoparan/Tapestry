package com.mt.feedlin.ui.feed

import com.mt.feedlin.R
import com.mt.feedlin.data.Feed
import com.mt.feedlin.injection.component.ActivityComponent
import com.mt.feedlin.ui.base.BaseActivity
import com.mt.feedlin.util.hide
import com.mt.feedlin.util.show
import com.mt.feedlin.ui.adapter.RecyclerAdapter
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_main.*

class FeedsActivity : BaseActivity<FeedsView, FeedsPresenter>(), FeedsView {

    @Inject override lateinit var presenter: FeedsPresenter

    override fun setupComponent(component: ActivityComponent) = component.inject(this)

    override var layoutID = R.layout.activity_main

    private var adapter: RecyclerAdapter<FeedsHolder, Feed>? = null

    override fun setupViews() {
        adapter = RecyclerAdapter<FeedsHolder, Feed>(
                FeedsHolder::class.java, R.layout.item_feed,
                { holder, feed -> holder.bind(feed, { presenter.navigator.shareFeed(feed) }) })
        adapter?.setHasStableIds(true)

        recyclerFeeds.setHasFixedSize(true)
        recyclerFeeds.adapter = adapter
    }

    override fun showFeeds(feeds: MutableList<Feed>) {
        empty.hide(); error.hide(); recyclerFeeds.show()
        adapter?.items = feeds
    }

    override fun showProgress(active: Boolean) {
        if (active) progress.show() else progress.hide()
    }

    override fun showEmpty() {
        error.hide(); recyclerFeeds.hide(); empty.show()
    }

    override fun showError() {
        empty.hide(); recyclerFeeds.hide(); error.show()
    }
}
