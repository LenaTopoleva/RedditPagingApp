package com.lenatopoleva.redditpagingapp.view.imageloader

import android.graphics.Bitmap
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.lenatopoleva.redditpagingapp.R
import com.lenatopoleva.redditpagingapp.model.imageloader.IImageLoader

class GlideImageLoader(): IImageLoader<ImageView> {
    override fun loadInto(url: String, container: ImageView) {
        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transform(CenterCrop(), RoundedCorners(25), )

        Glide.with(container.context)
            .asBitmap()
            .load(url)
            .apply(requestOptions)
            .placeholder(R.drawable.ic_baseline_image_search_24)
            .listener(object : RequestListener<Bitmap> {
                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Bitmap>?, isFirstResource: Boolean): Boolean {
                    //Do stuff with error
                    return false
                }
                override fun onResourceReady(
                    resource: Bitmap?,
                    model: Any?,
                    target: Target<Bitmap>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    //Do stuff with result
                    return false
                }
            })
            .into(container)

    }

}