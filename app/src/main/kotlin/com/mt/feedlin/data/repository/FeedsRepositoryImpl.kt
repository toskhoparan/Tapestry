package com.mt.feedlin.data.repository

import com.mt.feedlin.data.model.Feed
import com.mt.feedlin.data.persistence.dao.FeedsDao
import com.mt.feedlin.network.FeedsService
import com.mt.feedlin.util.ext.toDate
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by max on 24-May-17.
 */

@Singleton
class FeedsRepositoryImpl
@Inject constructor(val feedsService: FeedsService, val feedsDao: FeedsDao) : FeedsRepository {

    companion object {
        const val REFRESH_TIME = 30 //seconds
    }

    private var lastUpdate: Long = 0L

    override fun loadFeeds(forceLoad: Boolean): Flowable<MutableList<Feed>> {
        if (forceLoad || requireRefresh()) return loadRemoteFeeds()
        return loadLocalFeeds()
    }

    private fun loadRemoteFeeds() = feedsService.getFeeds()
            .map { it.channel!!.feeds }
            .flatMap { Flowable.fromIterable(it) }
            .toSortedList { f1, f2 -> f2.pubDate.toDate().compareTo(f1.pubDate.toDate()) }
            .doOnSuccess {
                feedsDao.insertAll(it)
                lastUpdate = System.currentTimeMillis()
            }.toFlowable()

    private fun loadLocalFeeds() = Flowable.fromCallable { feedsDao.getAll() }

    private fun requireRefresh(): Boolean {
        if (lastUpdate == 0L) return true
        return (System.currentTimeMillis() - lastUpdate) / 1000 > REFRESH_TIME
    }
}
