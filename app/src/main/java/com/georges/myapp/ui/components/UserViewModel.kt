package com.georges.myapp.ui.components

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.georges.myapp.data.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    fun registerUser(username: String, password: String) {
        viewModelScope.launch {
            userRepository.registerUser(username, password)
        }
    }

    fun loginUser(username: String, password: String, callback: (Boolean) -> Unit) {
        viewModelScope.launch {
            callback(userRepository.loginUser(username, password))
        }
    }

    fun logoutUser() {
        TODO("Not yet implemented")
    }
}
