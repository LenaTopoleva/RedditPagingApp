package com.lenatopoleva.redditpagingapp.model.datasource

import androidx.paging.PagingData
import com.lenatopoleva.redditpagingapp.model.data.RedditPost
import kotlinx.coroutines.flow.Flow


interface DataSource<T> {
    fun getHotList(subReddit: String, pageSize: Int): Flow<PagingData<RedditPost>>

}