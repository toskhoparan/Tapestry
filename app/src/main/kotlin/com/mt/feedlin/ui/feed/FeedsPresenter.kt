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
@Inject constructor(val repository: FeedsRepository, val navigator: FeedsContract.Navigator)
    : BaseAbstractPresenter<FeedsContract.View>(), FeedsContract.Presenter {

    override fun loadData() {
        loadFeeds()
    }

    private fun loadFeeds() {
        view?.showProgress(true)
        disposables.add(repository.loadFeeds()
                .io()
                .subscribe(
                        {
                            if (!it.isEmpty())
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

    override fun navigator() = navigator
}