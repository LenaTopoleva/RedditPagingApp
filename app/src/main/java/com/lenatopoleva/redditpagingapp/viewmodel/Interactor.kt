package com.lenatopoleva.redditpagingapp.viewmodel

import io.reactivex.Observable

interface Interactor<T> {
    fun getHotList(fromRemoteSource: Boolean): Observable<T>
}