package com.lenatopoleva.redditpagingapp.model.datasource

import androidx.paging.*
import androidx.room.withTransaction
import com.lenatopoleva.redditpagingapp.model.db.RedditDb
import com.lenatopoleva.redditpagingapp.model.db.RedditPostDao
import com.lenatopoleva.redditpagingapp.model.db.SubredditRemoteKeyDao
import com.lenatopoleva.redditpagingapp.model.db.entity.RedditPost
import com.lenatopoleva.redditpagingapp.model.db.entity.SubredditRemoteKey
import retrofit2.HttpException
import java.io.IOException

@ExperimentalPagingApi
class PagingRemoteMediator(
    private val db: RedditDb,
    private val remoteProvider: ApiService,
    private val subredditName: String):
        RemoteMediator<Int, RedditPost>() {
    private val postDao: RedditPostDao = db.posts()
    private val remoteKeyDao: SubredditRemoteKeyDao = db.remoteKeys()

    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }

    override suspend fun load(
            loadType: LoadType,
            state: PagingState<Int, RedditPost>
    ): MediatorResult {
        try {
            // Get the closest item from PagingState that we want to load data around.
            val loadKey = when (loadType) {
                LoadType.REFRESH -> null
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val remoteKey = db.withTransaction {
                        remoteKeyDao.remoteKeyByPost(subredditName)
                    }
                    if (remoteKey.nextPageKey == null) {
                        return MediatorResult.Success(endOfPaginationReached = true)
                    }
                    remoteKey.nextPageKey
                }
            }

            val data = remoteProvider.getHotList(
                    subreddit = subredditName,
                    after = loadKey,
                    before = null,
                    limit = when (loadType) {
                        LoadType.REFRESH -> state.config.initialLoadSize
                        else -> state.config.pageSize
                    }
            ).data

            val items = data.children.map { it.data }

            db.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    postDao.deleteBySubreddit(subredditName)
                    remoteKeyDao.deleteBySubreddit(subredditName)
                }

                remoteKeyDao.insert(SubredditRemoteKey(subredditName, data.after))
                postDao.insertAll(items)
            }

            return MediatorResult.Success(endOfPaginationReached = items.isEmpty())
        } catch (e: IOException) {
            return MediatorResult.Error(e)
        } catch (e: HttpException) {
            return MediatorResult.Error(e)
        }
    }
}
