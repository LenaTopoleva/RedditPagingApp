package com.lenatopoleva.redditpagingapp.model.repository

import com.lenatopoleva.redditpagingapp.model.data.DataModel
import com.lenatopoleva.redditpagingapp.model.datasource.DataSource
import io.reactivex.Observable


class RepositoryImplementation(private val dataSource: DataSource<DataModel>) :
    Repository<DataModel> {

    override fun getHotList(): Observable<DataModel> {
        return dataSource.getHotList()
    }

}
