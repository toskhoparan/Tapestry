package com.mt.feedlin.injection.feeds

import com.mt.feedlin.data.Feed
import com.mt.feedlin.injection.scope.ActivityScope
import com.mt.feedlin.ui.adapter.RecyclerAdapter
import com.mt.feedlin.ui.feed.*
import dagger.Module
import dagger.Provides

/**
 * Created by max on 23-May-17.
 */

@Module
class FeedsModule (val activity: FeedsActivity) {

    @Provides @ActivityScope
    fun providePresenter(presenter: FeedsPresenter): FeedsContract.Presenter = presenter

    @Provides @ActivityScope
    fun provideAdapter(): RecyclerAdapter<FeedsHolder, Feed> = RecyclerAdapter(FeedsHolder::class.java)

    @Provides @ActivityScope
    fun provideNavigator(): FeedsContract.Navigator = FeedsNavigator(activity)
}