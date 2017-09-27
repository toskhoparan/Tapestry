package com.mt.feedlin.injection.repository

import com.mt.feedlin.data.repository.FeedsRepository
import com.mt.feedlin.data.repository.FeedsRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by max on 24-May-17.
 */

@Module
class RepositoryModule {

    @Provides @Singleton
    fun provideFeedsRepository(repository: FeedsRepositoryImpl): FeedsRepository = repository
}