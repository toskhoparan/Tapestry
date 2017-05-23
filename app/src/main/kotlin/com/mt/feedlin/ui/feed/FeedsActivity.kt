package com.mt.feedlin.ui.feed

import com.mt.feedlin.R
import com.mt.feedlin.data.Feed
import com.mt.feedlin.injection.app.ApplicationComponent
import com.mt.feedlin.injection.feeds.DaggerFeedsComponent
import com.mt.feedlin.injection.feeds.FeedsModule
import com.mt.feedlin.ui.base.BaseActivity
import com.mt.feedlin.util.ext.hide
import com.mt.feedlin.util.ext.show
import com.mt.feedlin.ui.adapter.RecyclerAdapter
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_main.*

class FeedsActivity : BaseActivity<FeedsContract.View, FeedsContract.Presenter>(), FeedsContract.View {

    override var layoutID = R.layout.activity_main
    @Inject override lateinit var presenter: FeedsContract.Presenter
    @Inject lateinit var adapter: RecyclerAdapter<FeedsHolder, Feed>

    override fun setupComponent(component: ApplicationComponent) {
        DaggerFeedsComponent.builder().applicationComponent(component)
                .feedsModule(FeedsModule(this)).build().inject(this)
    }

    override fun setupViews() {
        adapter.apply {
            layoutRes = R.layout.item_feed
            binder = { holder, feed -> holder.bind(feed,
                    { presenter.navigator().shareFeed(feed) }) }
        }

        recyclerFeeds.setHasFixedSize(true)
        recyclerFeeds.adapter = adapter
    }

    override fun showFeeds(feeds: MutableList<Feed>) {
        empty.hide(); error.hide(); recyclerFeeds.show()
        adapter.items = feeds
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
