package com.mt.tapestry.ui.feed

import com.mt.tapestry.data.entity.Feed
import com.mt.tapestry.ui.adapter.RecyclerAdapter
import dagger.Module
import dagger.Provides

/**
 * Created by max on 23-May-17.
 */

@Module
class FeedsModule {

    @Provides
    fun providePresenter(presenter: FeedsPresenter): FeedsContract.Presenter = presenter

    @Provides
    fun provideAdapter(): RecyclerAdapter<FeedsHolder, Feed> = RecyclerAdapter(FeedsHolder::class.java)
}