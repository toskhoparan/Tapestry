package com.mt.feedlin.injection.persistence

import android.arch.persistence.room.Room
import android.content.Context
import com.mt.feedlin.data.persistence.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by max on 24-May-17.
 */

@Module
class PersistenceModule {

    companion object {
        const val DB_NAME = "feedlin.db"
    }

    @Provides @Singleton
    fun provideDatabase(context: Context): AppDatabase
            = Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME).build()

    @Provides @Singleton
    fun provideFeedsDao(db: AppDatabase) = db.feedsDao()
}