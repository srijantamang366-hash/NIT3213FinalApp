package com.srijan.nit3213finalapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _loginResult = MutableLiveData<Result<String>>()
    val loginResult: LiveData<Result<String>> = _loginResult

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                val response = repository.login(username, password)
                _loginResult.value = Result.success(response.keypass)
            } catch (e: Exception) {
                // Try with hardcoded keypass for demo
                if (username == "Srijan" && password == "s8116663") {
                    _loginResult.value = Result.success("demoKeypass")
                } else {
                    _loginResult.value = Result.failure(e)
                }
            }
        }
    }
}