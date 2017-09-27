package com.mt.tapestry.ui.feed

import com.mt.tapestry.data.repository.FeedsRepository
import com.mt.tapestry.injection.scope.ActivityScope
import com.mt.tapestry.ui.base.presenter.AbstractPresenter
import com.mt.tapestry.util.ext.io
import javax.inject.Inject

/**
 * Created by m_toskhoparan on 08-May-17.
 */

@ActivityScope
class FeedsPresenter
@Inject constructor(val repository: FeedsRepository,
                    val navigator: FeedsContract.Navigator)
    : AbstractPresenter<FeedsContract.View, FeedsContract.State>(), FeedsContract.Presenter {

    override fun loadData(refresh: Boolean) = loadFeeds(refresh)

    private fun loadFeeds(refresh: Boolean) {
        view?.showProgress(true)
        subscriptions?.add(
            repository.loadFeeds(refresh)
                .io()
                .subscribe(
                    {
                        if (!it.isEmpty()) view?.showFeeds(it, state?.itemPosition)
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

    override var state: FeedsContract.State? = FeedsState()

    override fun saveState(state: FeedsContract.State?) {
        state?.itemPosition = view?.getItemPosition()
    }

    override fun navigator() = navigator
}