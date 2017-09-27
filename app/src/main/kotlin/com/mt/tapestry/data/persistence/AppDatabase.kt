package com.mt.tapestry.data.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.mt.tapestry.data.model.Feed
import com.mt.tapestry.data.persistence.dao.FeedsDao

/**
 * Created by max on 24-May-17.
 */

@Database(entities = arrayOf(Feed::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun feedsDao(): FeedsDao
}