package com.lenatopoleva.redditpagingapp.view.main

import androidx.paging.PagingData
import com.lenatopoleva.redditpagingapp.model.data.RedditPost
import com.lenatopoleva.redditpagingapp.model.data.RedditResponse
import com.lenatopoleva.redditpagingapp.model.repository.Repository
import com.lenatopoleva.redditpagingapp.viewmodel.Interactor
import kotlinx.coroutines.flow.Flow

class MainInteractor(
    private val remoteRepository: Repository<RedditResponse>,
    private val localRepository: Repository<RedditResponse>,
) : Interactor<Flow<PagingData<RedditPost>>> {

    override fun getHotList(fromRemoteSource: Boolean, subReddit: String,
                            pageSize: Int):
            Flow<PagingData<RedditPost>> {
        return if (fromRemoteSource) {
            remoteRepository.getHotList(subReddit, pageSize)
        } else {
           localRepository.getHotList(subReddit, pageSize)
        }
    }

}