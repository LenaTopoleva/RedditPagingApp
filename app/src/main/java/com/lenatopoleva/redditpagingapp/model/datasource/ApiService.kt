package com.lenatopoleva.redditpagingapp.model.datasource

import com.lenatopoleva.redditpagingapp.model.data.DataModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("r/aww/hot.json")
    fun getHotList(): Observable<DataModel>
}