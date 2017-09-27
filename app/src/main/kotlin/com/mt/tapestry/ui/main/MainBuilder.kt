package com.mt.tapestry.ui.main

import com.mt.tapestry.ui.feed.FeedsBuilder
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by m_toskhoparan on 09/27/17.
 */
@Module
abstract class MainBuilder {

    @ContributesAndroidInjector(modules = arrayOf(
            MainModule::class,
            FeedsBuilder::class
    ))
    abstract fun contributeMainActivity(): MainActivity
}