package com.mt.tapestry.data.repository

import com.mt.tapestry.data.entity.Feed
import com.mt.tapestry.data.persistence.dao.FeedsDao
import com.mt.tapestry.data.network.WebService
import com.mt.tapestry.util.ext.toDate
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by max on 24-May-17.
 */

@Singleton
class FeedsRepositoryImpl
@Inject constructor(val webService: WebService, val feedsDao: FeedsDao) : FeedsRepository {

    companion object {
        const val REFRESH_TIME = 30 //seconds
    }

    private var lastUpdate: Long = 0L

    override fun loadFeeds(forceLoad: Boolean): Flowable<MutableList<Feed>> {
        if (forceLoad || requireRefresh())
            return loadRemoteFeeds().startWith(loadLocalFeeds())
        return loadLocalFeeds()
    }

    private fun loadRemoteFeeds() = webService.getFeeds()
            .map { it.channel?.feeds }
            .flatMap { Flowable.fromIterable(it) }
            .toSortedList { f1, f2 -> f2.pubDate.toDate().compareTo(f1.pubDate.toDate()) }
            .doOnSuccess {
                feedsDao.insertAll(it)
                lastUpdate = System.currentTimeMillis()
            }
            .toFlowable()

    private fun loadLocalFeeds() = Flowable.fromCallable { feedsDao.getAll() }
            .flatMap { Flowable.fromIterable(it) }
            .toSortedList { f1, f2 -> f2.pubDate.toDate().compareTo(f1.pubDate.toDate()) }
            .toFlowable()

    private fun requireRefresh(): Boolean {
        if (lastUpdate == 0L) return true
        return (System.currentTimeMillis() - lastUpdate) / 1000 > REFRESH_TIME
    }
}
