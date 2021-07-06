package com.lenatopoleva.redditpagingapp.model.repository

import androidx.paging.PagingData
import com.lenatopoleva.redditpagingapp.model.db.entity.RedditPost
import kotlinx.coroutines.flow.Flow


interface IRepository {

     fun getHotList(subReddit: String, pageSize: Int): Flow<PagingData<RedditPost>>


}