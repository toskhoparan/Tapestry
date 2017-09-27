package com.mt.tapestry.data.repository

import com.mt.tapestry.data.entity.Feed
import io.reactivex.Flowable

/**
 * Created by max on 24-May-17.
 */

interface FeedsRepository {

    fun loadFeeds(forceLoad: Boolean = true): Flowable<MutableList<Feed>>
}