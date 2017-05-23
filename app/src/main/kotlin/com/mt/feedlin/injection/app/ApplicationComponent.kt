package com.mt.feedlin.injection.app

import android.content.Context
import com.mt.feedlin.network.FeedsService
import dagger.Component
import javax.inject.Singleton

/**
 * Created by max on 05-May-17.
 */

@Singleton @Component(modules = arrayOf(ApplicationModule::class, NetworkModule::class))
interface ApplicationComponent {

    val context: Context

    val feedsService: FeedsService
}