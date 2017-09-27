package com.mt.tapestry.injection.app

import android.content.Context
import com.mt.tapestry.data.persistence.AppDatabase
import com.mt.tapestry.data.persistence.dao.FeedsDao
import com.mt.tapestry.data.repository.FeedsRepository
import com.mt.tapestry.injection.network.NetworkModule
import com.mt.tapestry.injection.persistence.PersistenceModule
import com.mt.tapestry.injection.repository.RepositoryModule
import com.mt.tapestry.network.WebService
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

    val webService: WebService

    val appDatabase: AppDatabase

    val feedsDao: FeedsDao

    val feedsRepository: FeedsRepository
}