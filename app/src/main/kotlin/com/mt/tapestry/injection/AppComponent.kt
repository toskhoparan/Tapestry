package com.mt.tapestry.injection

import com.mt.tapestry.TapestryApp
import com.mt.tapestry.ui.main.MainBuilder
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by max on 05-May-17.
 */

@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        AppModule::class,
        MainBuilder::class))
interface AppComponent : AndroidInjector<TapestryApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<TapestryApp>()
}