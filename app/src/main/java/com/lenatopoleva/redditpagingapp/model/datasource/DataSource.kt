package com.lenatopoleva.redditpagingapp.model.datasource

import io.reactivex.Observable


interface DataSource<T> {
    fun getHotList(): Observable<T>
}