package com.mt.feedlin

import android.app.Application
import com.mt.feedlin.injection.app.ApplicationComponent
import com.mt.feedlin.injection.app.ApplicationModule
import com.mt.feedlin.injection.app.DaggerApplicationComponent

/**
 * Created by max on 05-May-17.
 */

class FeedlinApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this)).build()
    }
}
