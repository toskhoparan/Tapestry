package com.mt.tapestry.network

import com.mt.tapestry.data.model.RSS
import io.reactivex.Flowable
import retrofit2.http.GET

/**
 * Created by m_toskhoparan on 08-May-17.
 */
interface WebService {

    @GET("rss.xml")
    fun getFeeds() : Flowable<RSS>
}