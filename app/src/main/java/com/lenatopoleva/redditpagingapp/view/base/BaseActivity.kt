package com.lenatopoleva.redditpagingapp.view.base

import androidx.appcompat.app.AppCompatActivity
import com.lenatopoleva.redditpagingapp.model.data.AppState
import com.lenatopoleva.redditpagingapp.viewmodel.BaseViewModel
import com.lenatopoleva.redditpagingapp.viewmodel.Interactor

abstract class BaseActivity<T: AppState, I: Interactor<T>>: AppCompatActivity() {

    abstract  val model: BaseViewModel<T>

    abstract fun renderData(dataModel: T)

}