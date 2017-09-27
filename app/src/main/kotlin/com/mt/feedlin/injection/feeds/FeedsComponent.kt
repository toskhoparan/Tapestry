package com.mt.feedlin.injection.feeds

import com.mt.feedlin.injection.app.ApplicationComponent
import com.mt.feedlin.injection.scope.ActivityScope
import com.mt.feedlin.ui.feed.FeedsActivity
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