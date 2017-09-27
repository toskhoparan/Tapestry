package com.mt.tapestry

import android.app.Application
import com.mt.tapestry.injection.app.ApplicationComponent
import com.mt.tapestry.injection.app.ApplicationModule
import com.mt.tapestry.injection.app.DaggerApplicationComponent

/**
 * Created by max on 05-May-17.
 */

class TapestryApp : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this)).build()
    }
}
