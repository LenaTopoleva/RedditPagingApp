package com.lenatopoleva.redditpagingapp.di.modules

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.lenatopoleva.redditpagingapp.model.datasource.ApiService
import com.lenatopoleva.redditpagingapp.model.datasource.BaseInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {

    private val baseUrl = "https://www.reddit.com/"

    @Named("baseUrl")
    @Provides
    fun baseUrl(): String {
        return baseUrl
    }

    @Singleton
    @Provides
    fun api(@Named("baseUrl") baseUrl: String, client: OkHttpClient): ApiService = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)


    @Singleton
    @Provides
    fun client() = OkHttpClient.Builder()
        .callTimeout(30, TimeUnit.SECONDS)
        .addNetworkInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.HEADERS })
        .addInterceptor(BaseInterceptor.interceptor)
        .build()

}