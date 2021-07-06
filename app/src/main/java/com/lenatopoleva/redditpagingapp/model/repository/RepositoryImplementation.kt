package com.lenatopoleva.redditpagingapp.model.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.lenatopoleva.redditpagingapp.model.datasource.ApiService
import com.lenatopoleva.redditpagingapp.model.datasource.PagingRemoteMediator
import com.lenatopoleva.redditpagingapp.model.db.RedditDb


class RepositoryImplementation(val db: RedditDb, val remoteProvider: ApiService) :
    IRepository {

    @ExperimentalPagingApi
    override fun getHotList(subReddit: String, pageSize: Int) = Pager(
            config = PagingConfig(pageSize),
            remoteMediator = PagingRemoteMediator(db, remoteProvider, subReddit)
    ) {
        db.posts().postsBySubreddit(subReddit)
    }.flow

}
