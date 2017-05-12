package com.mt.feedlin.network

import com.mt.feedlin.data.RSS
import io.reactivex.Flowable
import retrofit2.http.GET

/**
 * Created by m_toskhoparan on 08-May-17.
 */
interface FeedsService {

    @GET("rss.xml")
    fun getFeeds() : Flowable<RSS>
}