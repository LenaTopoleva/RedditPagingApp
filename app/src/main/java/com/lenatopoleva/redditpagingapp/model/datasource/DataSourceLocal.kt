package com.lenatopoleva.redditpagingapp.model.datasource

import com.lenatopoleva.redditpagingapp.model.data.DataModel
import io.reactivex.Observable

class DataSourceLocal(private val remoteProvider: RoomDataBaseImplementation = RoomDataBaseImplementation()) :
    DataSource<DataModel> {

    override fun getHotList(): Observable<DataModel> = remoteProvider.getHotList()
}
