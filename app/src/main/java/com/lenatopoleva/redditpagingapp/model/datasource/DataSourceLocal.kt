package com.lenatopoleva.redditpagingapp.model.datasource

import androidx.paging.PagingData
import com.lenatopoleva.redditpagingapp.model.data.RedditPost
import com.lenatopoleva.redditpagingapp.model.data.RedditResponse
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow

class DataSourceLocal(private val localProvider: RoomDataBaseImplementation = RoomDataBaseImplementation()) :
    DataSource<RedditResponse> {
    override fun getHotList(subReddit: String, pageSize: Int): Flow<PagingData<RedditPost>> {
        TODO("Not yet implemented")
    }


}
