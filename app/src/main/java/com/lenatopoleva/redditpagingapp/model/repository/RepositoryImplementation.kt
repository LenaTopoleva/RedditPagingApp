package com.lenatopoleva.redditpagingapp.model.repository

import androidx.paging.PagingData
import com.lenatopoleva.redditpagingapp.model.data.RedditPost
import com.lenatopoleva.redditpagingapp.model.data.RedditResponse
import com.lenatopoleva.redditpagingapp.model.datasource.DataSource
import kotlinx.coroutines.flow.Flow


class RepositoryImplementation(private val dataSource: DataSource<RedditResponse>) :
    Repository<RedditResponse> {

    override fun getHotList(subReddit: String, pageSize: Int): Flow<PagingData<RedditPost>> {
        return dataSource.getHotList(subReddit, pageSize)
    }

}
