package com.mt.tapestry.data.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.mt.tapestry.data.entity.Feed

/**
 * Created by max on 24-May-17.
 */

@Dao
interface FeedsDao {

    @Query("SELECT * FROM feed")
    fun getAll(): MutableList<Feed>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(feeds: MutableList<Feed>)
}