package com.mt.tapestry.injection.feeds

import com.mt.tapestry.data.model.Feed
import com.mt.tapestry.injection.scope.ActivityScope
import com.mt.tapestry.ui.adapter.RecyclerAdapter
import com.mt.tapestry.ui.feed.*
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