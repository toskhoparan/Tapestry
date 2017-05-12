package com.mt.feedlin.injection.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by max on 12-May-17.
 */

@Module
class ApplicationModule constructor(val app: Application) {

    @Provides @Singleton
    fun provideContext() = app.applicationContext
}