package com.mt.feedlin.ui.feed

import com.mt.feedlin.data.repository.FeedsRepository
import com.mt.feedlin.injection.scope.ActivityScope
import com.mt.feedlin.ui.base.BaseAbstractPresenter
import com.mt.feedlin.util.ext.io
import javax.inject.Inject

/**
 * Created by m_toskhoparan on 08-May-17.
 */

@ActivityScope
class FeedsPresenter
@Inject constructor(val repository: FeedsRepository,
                    val navigator: FeedsContract.Navigator)
    : BaseAbstractPresenter<FeedsContract.View>(), FeedsContract.Presenter {

    override fun loadData(refresh: Boolean) = loadFeeds(refresh)

    private fun loadFeeds(refresh: Boolean) {
        view?.showProgress(true)
        subscriptions?.add(
            repository.loadFeeds(refresh)
                .io()
                .subscribe(
                    {
                        if (!it.isEmpty()) view?.showFeeds(it)
                        else if (dataLoaded) view?.showEmpty()
                    },
                    {
                        view?.showProgress(false)
                        if (!dataLoaded) view?.showError()
                    },
                    {
                        view?.showProgress(false)
                        dataLoaded = true
                    }
                )
        )
    }

    override fun navigator() = navigator
}