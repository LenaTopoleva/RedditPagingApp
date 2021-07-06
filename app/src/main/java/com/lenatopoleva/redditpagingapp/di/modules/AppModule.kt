package com.lenatopoleva.redditpagingapp.di.modules

import com.lenatopoleva.redditpagingapp.App
import com.lenatopoleva.redditpagingapp.model.db.RedditDb
import dagger.Module
import dagger.Provides


@Module
class AppModule(val app: App) {

    @Provides
    fun app(): App{
        return app
    }

    @Provides
    fun db(): RedditDb = RedditDb.create(app, false)
}