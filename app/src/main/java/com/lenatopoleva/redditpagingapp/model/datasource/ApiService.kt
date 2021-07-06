package com.lenatopoleva.redditpagingapp.model.datasource

import com.lenatopoleva.redditpagingapp.model.data.RedditResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("r/{subreddit}/hot.json")
    suspend fun getHotList(
        @Path("subreddit") subreddit: String,
        @Query("limit") limit: Int,
        @Query("after") after: String? = null,
        @Query("before") before: String? = null
    ): RedditResponse
}