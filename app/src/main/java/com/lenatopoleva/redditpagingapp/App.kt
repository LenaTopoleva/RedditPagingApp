package com.lenatopoleva.redditpagingapp

import android.app.Application
import com.lenatopoleva.redditpagingapp.di.AppComponent
import com.lenatopoleva.redditpagingapp.di.DaggerAppComponent
import com.lenatopoleva.redditpagingapp.di.modules.AppModule

class App: Application() {

    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent
    private set

            override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}