package com.theappbusiness.sample.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.theappbusiness.analyitcs.Analytics
import com.theappbusiness.sample.data.LoginDataSource
import com.theappbusiness.sample.data.LoginRepository

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
class LoginViewModelFactory(
    private val analytics: Analytics
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(
                loginRepository = LoginRepository(
                    dataSource = LoginDataSource()
                ),
                analytics = analytics
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
