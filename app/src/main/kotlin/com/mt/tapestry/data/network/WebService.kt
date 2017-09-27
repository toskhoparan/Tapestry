package com.mt.tapestry.data.network

import com.mt.tapestry.data.entity.RSS
import io.reactivex.Flowable
import retrofit2.http.GET

/**
 * Created by m_toskhoparan on 08-May-17.
 */
interface WebService {

    @GET("rss.xml")
    fun getFeeds() : Flowable<RSS>
}