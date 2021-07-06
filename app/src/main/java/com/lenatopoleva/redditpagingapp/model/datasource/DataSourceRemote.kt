package com.lenatopoleva.redditpagingapp.model.datasource

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.lenatopoleva.redditpagingapp.model.data.RedditPost
import com.lenatopoleva.redditpagingapp.model.data.RedditResponse
import kotlinx.coroutines.flow.Flow


class DataSourceRemote(private val remoteProvider: RetrofitImplementation = RetrofitImplementation()) :
    DataSource<RedditResponse>  {

    override fun getHotList(subReddit: String, pageSize: Int): Flow<PagingData<RedditPost>> =
        Pager ( PagingConfig(pageSize) ) {
            PagingSourceRemote(
                remoteProvider = remoteProvider,
                subredditName = subReddit
            )
        }.flow

}
