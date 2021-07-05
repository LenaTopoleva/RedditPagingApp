package com.lenatopoleva.redditpagingapp.view.main.activity

import android.view.View
import com.lenatopoleva.redditpagingapp.databinding.ActivityMainBinding


class ScreenErrorViewer(binding: ActivityMainBinding, private val error: String) :
    ScreenViewer(binding) {
    override fun showScreen() {
        showViewError()
        binding.errorTextview.text = error
    }

    private fun showViewError() {
        binding.successLinearLayout.visibility = View.GONE
        binding.loadingFrameLayout.visibility = View.GONE
        binding.errorLinearLayout.visibility = View.VISIBLE
    }
}