package com.lenatopoleva.redditpagingapp.model.repository

import androidx.paging.PagingData
import com.lenatopoleva.redditpagingapp.model.data.RedditPost
import com.lenatopoleva.redditpagingapp.model.data.RedditResponse
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow


interface Repository<T> {

     fun getHotList(subReddit: String, pageSize: Int): Flow<PagingData<RedditPost>>


}