package com.lenatopoleva.redditpagingapp.model.imageloader

interface IImageLoader<T> {
    fun loadInto(url: String, container: T)
}