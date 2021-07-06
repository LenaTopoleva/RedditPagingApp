package com.lenatopoleva.redditpagingapp.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lenatopoleva.redditpagingapp.model.db.entity.RedditPost
import com.lenatopoleva.redditpagingapp.model.db.entity.SubredditRemoteKey

@Database(
        entities = [RedditPost::class, SubredditRemoteKey::class],
        version = 1,
        exportSchema = false
)
abstract class RedditDb : RoomDatabase() {
    companion object {
        fun create(context: Context, useInMemory: Boolean): RedditDb {
            val databaseBuilder = if (useInMemory) {
                Room.inMemoryDatabaseBuilder(context, RedditDb::class.java)
            } else {
                Room.databaseBuilder(context, RedditDb::class.java, "reddit.db")
            }
            return databaseBuilder
                    .fallbackToDestructiveMigration()
                    .build()
        }
    }

    abstract fun posts(): RedditPostDao
    abstract fun remoteKeys(): SubredditRemoteKeyDao
}