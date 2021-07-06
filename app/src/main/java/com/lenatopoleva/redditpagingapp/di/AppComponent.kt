package com.lenatopoleva.redditpagingapp.di

import com.lenatopoleva.redditpagingapp.di.modules.ApiModule
import com.lenatopoleva.redditpagingapp.di.modules.AppModule
import com.lenatopoleva.redditpagingapp.di.modules.ImageLoaderModule
import com.lenatopoleva.redditpagingapp.di.modules.RepositoryModule
import com.lenatopoleva.redditpagingapp.view.main.activity.MainActivity
import com.lenatopoleva.redditpagingapp.viewmodel.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    ApiModule::class,
    RepositoryModule::class,
    ImageLoaderModule::class
])


interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainViewModel: MainViewModel)
}
