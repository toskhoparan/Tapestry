package com.mt.tapestry.ui.feed

import android.support.v7.widget.LinearLayoutManager
import com.mt.tapestry.R
import com.mt.tapestry.data.model.Feed
import com.mt.tapestry.injection.app.ApplicationComponent
import com.mt.tapestry.injection.feeds.DaggerFeedsComponent
import com.mt.tapestry.injection.feeds.FeedsModule
import com.mt.tapestry.ui.base.view.BaseActivity
import com.mt.tapestry.util.ext.hide
import com.mt.tapestry.util.ext.show
import com.mt.tapestry.ui.adapter.RecyclerAdapter
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_main.*

class FeedsActivity : BaseActivity<FeedsContract.View,
    FeedsContract.Presenter, FeedsContract.State>(), FeedsContract.View {

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
                    { presenter.navigator().shareFeed(feed) },
                    { presenter.navigator().openLink(feed.link)}) }
        }

        recyclerFeeds.setHasFixedSize(true)
        recyclerFeeds.adapter = adapter
    }

    override fun showFeeds(feeds: MutableList<Feed>, position: Int?) {
        empty.hide(); error.hide(); recyclerFeeds.show()
        adapter.items = feeds
        position?.let { recyclerFeeds.scrollToPosition(it) }
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

    override fun getItemPosition(): Int {
        val layoutManager = (recyclerFeeds.layoutManager as LinearLayoutManager)
        val pos = layoutManager.findFirstCompletelyVisibleItemPosition()
        return if (pos != -1) pos else layoutManager.findFirstVisibleItemPosition()
    }
}