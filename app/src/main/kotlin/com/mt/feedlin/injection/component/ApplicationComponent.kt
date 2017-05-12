package com.mt.feedlin.injection.component

import com.mt.feedlin.injection.module.ApplicationModule
import com.mt.feedlin.injection.module.BindingsModule
import com.mt.feedlin.injection.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by max on 05-May-17.
 */

@Singleton @Component(modules = arrayOf(
        ApplicationModule::class, BindingsModule::class, NetworkModule::class))
interface ApplicationComponent {

    fun activityComponent(): ActivityComponent
}