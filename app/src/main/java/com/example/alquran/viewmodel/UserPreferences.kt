package com.example.alquran.viewmodel

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "user_prefs")

object UserPreferences {

    private val USER_NAME = stringPreferencesKey("user_name")
    private val USER_EMAIL = stringPreferencesKey("user_email")

    suspend fun saveUser(context: Context, name: String?, email: String?) {
        context.dataStore.edit { preferences ->
            preferences[USER_NAME] = name ?: ""
            preferences[USER_EMAIL] = email ?: ""
        }
    }

    fun getUser(context: Context): Flow<Pair<String, String>> {
        return context.dataStore.data.map { preferences ->
            val name = preferences[USER_NAME] ?: ""
            val email = preferences[USER_EMAIL] ?: ""
            Pair(name, email)
        }
    }

    suspend fun clearUser(context: Context) {
        context.dataStore.edit { preferences ->
            preferences.clear()
        }
    }
}
