package com.mt.tapestry.injection.repository

import com.mt.tapestry.data.repository.FeedsRepository
import com.mt.tapestry.data.repository.FeedsRepositoryImpl
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