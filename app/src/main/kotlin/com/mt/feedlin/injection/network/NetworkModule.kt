package com.mt.feedlin.injection.network

import com.mt.feedlin.BuildConfig
import com.mt.feedlin.network.FeedsService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import javax.inject.Singleton

/**
 * Created by m_toskhoparan on 08-May-17.
 */

@Module
class NetworkModule {

    companion object {
        const val BBC_API_URL = "http://feeds.bbci.co.uk/news/"
    }

    @Provides @Singleton
    fun provideFeedsService() : FeedsService {

        val interceptor = HttpLoggingInterceptor();
        interceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

        val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.createNonStrict())
                .client(client)
                .baseUrl(BBC_API_URL)
                .build()

        return retrofit.create(FeedsService::class.java)
    }
}