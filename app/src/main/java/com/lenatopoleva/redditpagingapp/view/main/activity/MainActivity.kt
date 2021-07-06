package com.lenatopoleva.redditpagingapp.view.main.activity

import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import com.lenatopoleva.redditpagingapp.databinding.ActivityMainBinding
import com.lenatopoleva.redditpagingapp.viewmodel.MainViewModel
import com.lenatopoleva.redditpagingapp.view.main.adapter.PostsAdapter
import androidx.activity.viewModels
import androidx.paging.LoadState
import com.lenatopoleva.redditpagingapp.App
import com.lenatopoleva.redditpagingapp.model.imageloader.IImageLoader
import com.lenatopoleva.redditpagingapp.utils.paging.asMergedLoadStates
import com.lenatopoleva.redditpagingapp.view.main.adapter.PostsLoadStateAdapter
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChangedBy
import kotlinx.coroutines.flow.filter
import javax.inject.Inject


class MainActivity: AppCompatActivity() {

    @Inject
    lateinit var glide: IImageLoader<ImageView>

    private val model: MainViewModel by viewModels<MainViewModel>()
    private lateinit var adapter: PostsAdapter
    private lateinit var binding: ActivityMainBinding

    init { App.instance.appComponent.inject(this) }

    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        println("MainActivity onCreate")
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()
        initSwipeToRefresh()
        initSearch()    }

    @FlowPreview
    @InternalCoroutinesApi
    private fun initAdapter() {
        adapter = PostsAdapter(glide)
        binding.list.adapter = adapter.withLoadStateHeaderAndFooter(
            header = PostsLoadStateAdapter(adapter),
            footer = PostsLoadStateAdapter(adapter)
        )

        lifecycleScope.launchWhenCreated {
            adapter.loadStateFlow.collectLatest { loadStates ->
                binding.swipeRefresh.isRefreshing = loadStates.mediator?.refresh is LoadState.Loading
            }
        }

        lifecycleScope.launchWhenCreated {
            model.posts.collectLatest {
                adapter.submitData(it)
            }
        }

        lifecycleScope.launchWhenCreated {
            adapter.loadStateFlow
                // Use a state-machine to track LoadStates such that we only transition to
                // NotLoading from a RemoteMediator load if it was also presented to UI.
                .asMergedLoadStates()
                // Only emit when REFRESH changes, as we only want to react on loads replacing the
                // list.
                .distinctUntilChangedBy { it.refresh }
                // Only react to cases where REFRESH completes i.e., NotLoading.
                .filter { it.refresh is LoadState.NotLoading }
                // Scroll to top is synchronous with UI updates, even if remote load was triggered.
                .collect { binding.list.scrollToPosition(0) }
        }
    }

    private fun initSwipeToRefresh() {
        binding.swipeRefresh.setOnRefreshListener { adapter.refresh() }
    }

    private fun initSearch() {
        binding.input.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_GO) {
                updatedSubredditFromInput()
                true
            } else {
                false
            }
        }
        binding.input.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                updatedSubredditFromInput()
                true
            } else {
                false
            }
        }
    }

    private fun updatedSubredditFromInput() {
        binding.input.text?.trim().toString().let {
            if (it.isNotBlank() && model.shouldShowSubreddit(it)) {
                model.showSubreddit(it)
            }
        }
    }
}


