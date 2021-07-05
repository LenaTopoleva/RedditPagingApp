package com.lenatopoleva.redditpagingapp.view.main.activity

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lenatopoleva.redditpagingapp.R
import com.lenatopoleva.redditpagingapp.databinding.ActivityMainBinding
import com.lenatopoleva.redditpagingapp.model.data.AppState
import com.lenatopoleva.redditpagingapp.model.data.ChildData
import com.lenatopoleva.redditpagingapp.model.data.DataModel
import com.lenatopoleva.redditpagingapp.view.base.BaseActivity
import com.lenatopoleva.redditpagingapp.view.main.MainInteractor
import com.lenatopoleva.redditpagingapp.view.main.MainViewModel
import com.lenatopoleva.redditpagingapp.view.main.adapter.MainAdapter

class MainActivity : BaseActivity<AppState, MainInteractor>() {

    override val model: MainViewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(MainViewModel::class.java)
    }
    private val observer = Observer<AppState> { renderData(it) }
    private val onListItemClickListener: MainAdapter.OnListItemClickListener =
        object : MainAdapter.OnListItemClickListener {
            override fun onItemClick(data: ChildData) {
                Toast.makeText(this@MainActivity, data.title, Toast.LENGTH_SHORT).show()
            }
        }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        println("MainActivity onCreate")
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        println("MainActivity initViews")
        model.getHotList(true).observe(this, observer)
        binding.reloadButton.setOnClickListener {
            model.getHotList(true).observe(this, observer)
        }
    }

    override fun renderData(appState: AppState) {
        val screenViewer: IScreenViewer = when (appState) {
            is AppState.Success -> {
                println("AppState.Success")
                val data = appState.data
                if (data == null) {
                    ScreenErrorViewer(
                        binding,
                        getString(R.string.empty_server_response_on_success)
                    )
                } else {
                    ScreenSuccessViewer(
                        binding,
                        onListItemClickListener,
                        data
                    )
                }
            }
            is AppState.Loading -> {
                println("AppState.Loading")
                ScreenLoadingViewer(
                    binding
                )
            }
            is AppState.Error -> {
                println("AppState.Error")
                ScreenErrorViewer(
                    binding,
                    appState.error.message ?: getString(R.string.undefined_error)
                )
            }
        }
        screenViewer.showScreen()
    }
}

