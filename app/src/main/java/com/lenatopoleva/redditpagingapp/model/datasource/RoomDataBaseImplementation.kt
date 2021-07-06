package com.lenatopoleva.redditpagingapp.model.datasource

import androidx.paging.PagingData
import com.lenatopoleva.redditpagingapp.model.data.RedditResponse
import io.reactivex.Observable

class RoomDataBaseImplementation {

    suspend fun getHotList(
        subreddit: String,
        limit: Int,
        after: String?,
        before: String?,
    ): RedditResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}