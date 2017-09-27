package com.mt.tapestry.injection.feeds

import com.mt.tapestry.injection.app.ApplicationComponent
import com.mt.tapestry.injection.scope.ActivityScope
import com.mt.tapestry.ui.feed.FeedsActivity
import dagger.Component

/**
 * Created by max on 10-May-17.
 */

@ActivityScope @Component(
        dependencies = arrayOf(ApplicationComponent::class),
        modules = arrayOf(FeedsModule::class))
interface FeedsComponent {

    fun inject(activity: FeedsActivity)
}