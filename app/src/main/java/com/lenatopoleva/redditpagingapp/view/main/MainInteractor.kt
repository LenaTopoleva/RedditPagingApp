package com.lenatopoleva.redditpagingapp.view.main

import com.lenatopoleva.redditpagingapp.model.data.AppState
import com.lenatopoleva.redditpagingapp.model.data.DataModel
import com.lenatopoleva.redditpagingapp.model.repository.Repository
import com.lenatopoleva.redditpagingapp.viewmodel.Interactor
import io.reactivex.Observable

class MainInteractor(
    private val remoteRepository: Repository<DataModel>,
    private val localRepository: Repository<DataModel>
) : Interactor<AppState> {

    override fun getHotList(fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            remoteRepository.getHotList().map { AppState.Success(it) }
        } else {
            localRepository.getHotList().map { AppState.Success(it) }
        }
    }
}