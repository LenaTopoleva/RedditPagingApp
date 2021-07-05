package com.lenatopoleva.redditpagingapp.model.repository

import io.reactivex.Observable


interface Repository<T> {

    fun getHotList(): Observable<T>

}