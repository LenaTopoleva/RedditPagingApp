package com.lenatopoleva.redditpagingapp.view.main

import androidx.lifecycle.LiveData
import com.lenatopoleva.redditpagingapp.model.data.AppState
import com.lenatopoleva.redditpagingapp.model.datasource.DataSourceLocal
import com.lenatopoleva.redditpagingapp.model.datasource.DataSourceRemote
import com.lenatopoleva.redditpagingapp.model.repository.RepositoryImplementation
import com.lenatopoleva.redditpagingapp.viewmodel.BaseViewModel
import io.reactivex.observers.DisposableObserver

class MainViewModel(
    private val interactor: MainInteractor = MainInteractor(
        RepositoryImplementation(DataSourceRemote()),
        RepositoryImplementation(DataSourceLocal())
    )
) : BaseViewModel<AppState>() {

    private var appState: AppState? = null

    override fun getHotList(isOnline: Boolean): LiveData<AppState> {
        println("MainViewModel getHotList()")
        compositeDisposable.add(
            interactor.getHotList(isOnline)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe { liveDataForViewToObserve.value = AppState.Loading }
                .subscribeWith(getObserver())
        )
        return super.getHotList(isOnline)
    }

    private fun getObserver(): DisposableObserver<AppState> {
        return object : DisposableObserver<AppState>() {

            override fun onNext(state: AppState) {
                appState = state
                liveDataForViewToObserve.value = state
            }

            override fun onError(e: Throwable) {
                liveDataForViewToObserve.value = AppState.Error(e)
            }

            override fun onComplete() {
            }
        }
    }
}