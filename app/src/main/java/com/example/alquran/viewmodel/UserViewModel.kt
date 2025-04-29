package com.example.alquran.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    val user = UserPreferences.getUser(application).asLiveData()

    fun saveUser(name: String?, email: String?) {
        viewModelScope.launch {
            UserPreferences.saveUser(getApplication(), name, email)
        }
    }

    fun clearUser() {
        viewModelScope.launch {
            UserPreferences.clearUser(getApplication())
        }
    }
}

