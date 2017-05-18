package com.mt.feedlin.ui.feed

import com.mt.feedlin.injection.scope.ActivityScope
import com.mt.feedlin.network.FeedsService
import com.mt.feedlin.ui.base.BaseAbstractPresenter
import com.mt.feedlin.ui.navigator.BaseNavigator
import com.mt.feedlin.util.io
import javax.inject.Inject

/**
 * Created by m_toskhoparan on 08-May-17.
 */

@ActivityScope
class FeedsPresenter
@Inject constructor(val feedsService: FeedsService,
                    val navigator: BaseNavigator) : BaseAbstractPresenter<FeedsView>() {

    override fun loadData() {
        loadFeeds()
    }

    private fun loadFeeds() {
        view?.showProgress(true)
        disposables.add(feedsService.getFeeds()
                .map { it.channel?.feeds }
                .io()
                .subscribe(
                        {
                            if (it != null && !it.isEmpty())
                                view?.showFeeds(it) else view?.showEmpty()
                        },
                        {
                            view?.showProgress(false)
                            if (!dataLoaded) view?.showError()
                        },
                        {
                            view?.showProgress(false)
                            dataLoaded = true
                        }
                ))
    }
}