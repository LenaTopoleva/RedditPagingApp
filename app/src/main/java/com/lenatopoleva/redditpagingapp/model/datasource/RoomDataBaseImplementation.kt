package com.lenatopoleva.redditpagingapp.model.datasource

import com.lenatopoleva.redditpagingapp.model.data.DataModel
import io.reactivex.Observable

class RoomDataBaseImplementation : DataSource<DataModel> {

    override fun getHotList(): Observable<DataModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}