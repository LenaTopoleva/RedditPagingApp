package com.lenatopoleva.redditpagingapp.di.modules

import com.lenatopoleva.redditpagingapp.model.datasource.ApiService
import com.lenatopoleva.redditpagingapp.model.db.RedditDb
import com.lenatopoleva.redditpagingapp.model.repository.IRepository
import com.lenatopoleva.redditpagingapp.model.repository.RepositoryImplementation
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun repository(localDataProvider: RedditDb, remoteDataProvider: ApiService): IRepository =
        RepositoryImplementation(localDataProvider, remoteDataProvider)

}