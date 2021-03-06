package app.explorior.sample.ui.login

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.explorior.analyitcs.Analytics
import app.explorior.sample.R
import app.explorior.sample.data.Result
import app.explorior.sample.data.LoginRepository
import app.explorior.sample.data.analytics.AnalyticsConstants.Event
import app.explorior.sample.data.analytics.AnalyticsConstants.Fields

class LoginViewModel(
    private val loginRepository: LoginRepository,
    private val analytics: Analytics
) : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    init {
        analytics.send(Event.LOGIN_SCREEN)
    }

    fun login(username: String, password: String) {
        // can be launched in a separate asynchronous job
        val result = loginRepository.login(username, password)

        if (result is Result.Success) {

            analytics.collect {
                "shhhhh" to true
            }

            analytics.send(Event.LOGIN_SUCCESS) {
                "screen_width" to 1600
                "test" to true
                "test_string" to ""
            }
            _loginResult.value =
                LoginResult(success = LoggedInUserView(displayName = result.data.displayName))
        } else {
            analytics.send(Event.LOGIN_ERROR) {
                Fields.USERNAME to username
                Fields.PASSWORD to password
            }
            _loginResult.value = LoginResult(error = R.string.login_failed)
        }
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}
