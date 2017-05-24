package com.mt.feedlin.injection.app

import android.content.Context
import com.mt.feedlin.data.persistence.AppDatabase
import com.mt.feedlin.data.persistence.dao.FeedsDao
import com.mt.feedlin.data.repository.FeedsRepository
import com.mt.feedlin.injection.network.NetworkModule
import com.mt.feedlin.injection.persistence.PersistenceModule
import com.mt.feedlin.injection.repository.RepositoryModule
import com.mt.feedlin.network.FeedsService
import dagger.Component
import javax.inject.Singleton

/**
 * Created by max on 05-May-17.
 */

@Singleton @Component(modules = arrayOf(
        ApplicationModule::class, NetworkModule::class,
        PersistenceModule::class, RepositoryModule::class))
interface ApplicationComponent {

    val context: Context

    val feedsService: FeedsService

    val appDatabase: AppDatabase

    val feedsDao: FeedsDao

    val feedsRepository: FeedsRepository
}