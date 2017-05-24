package com.mt.feedlin.data.repository

import com.mt.feedlin.data.persistence.dao.FeedsDao
import com.mt.feedlin.network.FeedsService
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by max on 24-May-17.
 */

@Singleton
class FeedsRepositoryImpl
@Inject constructor(val feedsService: FeedsService, val feedsDao: FeedsDao) : FeedsRepository {

    override fun loadFeeds() = loadRemoteFeeds().startWith(loadLocalFeeds())

    private fun loadRemoteFeeds() = feedsService.getFeeds()
            .map{ it.channel!!.feeds }
            .doOnNext{ feedsDao.insertAll(it) }

    private fun loadLocalFeeds() = Flowable.fromCallable { feedsDao.getAll() }
}