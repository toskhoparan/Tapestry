package com.mt.tapestry.ui.main

import com.mt.tapestry.ui.navigator.MainNavigator
import com.mt.tapestry.ui.navigator.MainNavigatorImpl
import dagger.Module
import dagger.Provides

/**
 * Created by m_toskhoparan on 09/27/17.
 */
@Module
class MainModule {

    @Provides
    fun provideNavigator(navigator: MainNavigatorImpl): MainNavigator = navigator
}