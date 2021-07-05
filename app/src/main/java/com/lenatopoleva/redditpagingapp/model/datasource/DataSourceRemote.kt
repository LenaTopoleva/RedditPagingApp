package com.lenatopoleva.redditpagingapp.model.datasource

import com.lenatopoleva.redditpagingapp.model.data.DataModel
import io.reactivex.Observable

class DataSourceRemote(private val remoteProvider: RetrofitImplementation = RetrofitImplementation()) :
    DataSource<DataModel> {

    override fun getHotList(): Observable<DataModel> = remoteProvider.getHotList()
}
