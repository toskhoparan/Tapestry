package com.mt.tapestry.ui.feed

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by m_toskhoparan on 09/27/17.
 */
@Module
abstract class FeedsBuilder {

    @ContributesAndroidInjector(modules = arrayOf(FeedsModule::class))
    abstract fun contributeFeedsFragment(): FeedsFragment
}