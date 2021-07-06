package com.lenatopoleva.redditpagingapp.di.modules

import android.widget.ImageView
import com.lenatopoleva.redditpagingapp.model.imageloader.IImageLoader
import com.lenatopoleva.redditpagingapp.view.imageloader.GlideImageLoader
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ImageLoaderModule {

    @Singleton
    @Provides
    fun imageLoader(): IImageLoader<ImageView> = GlideImageLoader()
}