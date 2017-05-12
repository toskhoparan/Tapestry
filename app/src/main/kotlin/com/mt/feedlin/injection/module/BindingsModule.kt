package com.mt.feedlin.injection.module

import com.mt.feedlin.ui.navigator.Navigator
import com.mt.feedlin.ui.navigator.BaseNavigator
import dagger.Binds
import dagger.Module

/**
 * Created by max on 10-May-17.
 */

@Module
abstract class BindingsModule {

    @Binds
    abstract fun bindNavigator(navigator: Navigator) : BaseNavigator
}