package com.mt.tapestry.ui.feed

import com.mt.tapestry.data.repository.FeedsRepository
import com.mt.tapestry.ui.base.SubscriptionPresenter
import com.mt.tapestry.util.RxSchedulers
import javax.inject.Inject

/**
 * Created by m_toskhoparan on 08-May-17.
 */

class FeedsPresenter
@Inject constructor(private val repository: FeedsRepository,
                    private val schedulers: RxSchedulers)
    : SubscriptionPresenter<FeedsContract.View>(), FeedsContract.Presenter {

    override fun onSubscribed() {
        loadFeeds()
    }

    override fun loadFeeds(refresh: Boolean) {
        view?.showProgress(true)

        doSubscribe(
            repository.loadFeeds(refresh)
                    .subscribeOn(schedulers.network)
                    .observeOn(schedulers.main)
                    .subscribe(
                        {
                            if (!it.isEmpty()) view?.showFeeds(it)
                            else view?.showNoFeeds()
                        },
                        {
                            view?.showProgress(false)
                            view?.showError()
                        },
                        {
                            view?.showProgress(false)
                        }
                    )
        )
    }
}