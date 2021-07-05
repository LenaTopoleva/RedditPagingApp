package com.lenatopoleva.redditpagingapp.view.main.activity

import android.view.View
import com.lenatopoleva.redditpagingapp.databinding.ActivityMainBinding

class ScreenLoadingViewer(binding: ActivityMainBinding) : ScreenViewer(binding) {
    override fun showScreen() {
        showViewLoading()
    }

    private fun showViewLoading() {
        binding.successLinearLayout.visibility = View.GONE
        binding.loadingFrameLayout.visibility = View.VISIBLE
        binding.errorLinearLayout.visibility = View.GONE
    }
}