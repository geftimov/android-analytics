package com.theappbusiness.sample.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.theappbusiness.analyitcs.Analytics

/**
 * ViewModel provider factory to instantiate MainViewModel.
 * Required given MainViewModel has a non-empty constructor
 */
class MainViewModelFactory(
    private val analytics: Analytics
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(
                analytics = analytics
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
