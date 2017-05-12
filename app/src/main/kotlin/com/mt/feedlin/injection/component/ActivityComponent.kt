package com.mt.feedlin.injection.component

import com.mt.feedlin.injection.scope.ActivityScope
import com.mt.feedlin.ui.feed.FeedsActivity
import dagger.Subcomponent

/**
 * Created by max on 10-May-17.
 */

@ActivityScope @Subcomponent
interface ActivityComponent {

    fun inject(activity: FeedsActivity)
}