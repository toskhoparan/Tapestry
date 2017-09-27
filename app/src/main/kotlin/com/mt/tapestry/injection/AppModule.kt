package com.mt.tapestry.injection

import android.arch.persistence.room.Room
import android.content.Context
import com.mt.tapestry.BuildConfig
import com.mt.tapestry.TapestryApp
import com.mt.tapestry.data.persistence.TapestryDatabase
import com.mt.tapestry.data.network.WebService
import com.mt.tapestry.data.repository.FeedsRepository
import com.mt.tapestry.data.repository.FeedsRepositoryImpl
import com.mt.tapestry.util.RxSchedulers
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.io.File
import javax.inject.Singleton

/**
 * Created by max on 12-May-17.
 */

@Module
class AppModule {

    @Provides
    fun provideContext(app: TapestryApp): Context = app.applicationContext

    @Provides @Singleton
    fun provideFeedsService(context: Context) : WebService {

        val interceptor = HttpLoggingInterceptor();
        interceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

        val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .cache(Cache(File(context.cacheDir, "feeds_cache"), 10 * 1024 * 1024))
                .build()

        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.createNonStrict())
                .client(client)
                .baseUrl("http://feeds.bbci.co.uk/news/")
                .build()

        return retrofit.create(WebService::class.java)
    }

    @Provides @Singleton
    fun provideSchedulers() = RxSchedulers()

    @Provides @Singleton
    fun provideDatabase(context: Context): TapestryDatabase
            = Room.databaseBuilder(context, TapestryDatabase::class.java, "feeds.db").build()

    @Provides
    fun provideFeedsDao(db: TapestryDatabase) = db.feedsDao()

    @Provides @Singleton
    fun provideFeedsRepository(repository: FeedsRepositoryImpl): FeedsRepository = repository
}