package com.lenatopoleva.redditpagingapp.viewmodel

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.lenatopoleva.redditpagingapp.App
import com.lenatopoleva.redditpagingapp.model.db.entity.RedditPost
import com.lenatopoleva.redditpagingapp.model.repository.IRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import javax.inject.Inject


class MainViewModel(
       private val savedStateHandle: SavedStateHandle,
       ): ViewModel() {

    private val subredditLiveData = MutableLiveData<String>().apply { value = DEFAULT_SUBREDDIT }

    @Inject
    lateinit var repository: IRepository

    companion object {
        const val DEFAULT_SUBREDDIT = "dog"
    }

    init { App.instance.appComponent.inject(this) }

    private val clearListCh = Channel<Unit>(Channel.CONFLATED)

    @FlowPreview
    @ExperimentalCoroutinesApi
    val posts = flowOf(
        clearListCh.receiveAsFlow().map { PagingData.empty<RedditPost>() },
            subredditLiveData
            .asFlow()
            .flatMapLatest { repository.getHotList(it, 10) }
            // cachedIn() shares the paging state across multiple consumers of posts,
            // e.g. different generations of UI across rotation config change
            .cachedIn(viewModelScope)
    ).flattenMerge(2)

    fun shouldShowSubreddit(
        subreddit: String
    ) = subredditLiveData.value != subreddit

    fun showSubreddit(subreddit: String) {
        if (!shouldShowSubreddit(subreddit)) return

        clearListCh.offer(Unit)

        subredditLiveData.postValue(subreddit)
    }

}