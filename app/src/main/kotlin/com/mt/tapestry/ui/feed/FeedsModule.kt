package com.mt.tapestry.ui.feed

import com.mt.simplerecycler.RecyclerViewHolder
import com.mt.tapestry.data.entity.Feed
import com.mt.tapestry.ui.feed.adapter.FeedsAdapter
import com.mt.tapestry.ui.feed.adapter.ViewHolderFactory
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
    fun provideViewHolderFactory(): RecyclerViewHolder.Factory<Feed> = ViewHolderFactory()

    @Provides
    fun provideAdapter(factory: RecyclerViewHolder.Factory<Feed>) = FeedsAdapter(factory)
}