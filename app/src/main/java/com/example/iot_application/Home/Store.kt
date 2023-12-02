package com.example.iot_application.Home

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Store(private val context : Context)
{
    val Context.dataStore : DataStore<Preferences> by preferencesDataStore("datastore")
    companion object{
        private val Led_Turn = booleanPreferencesKey("led_turn")
    }
    suspend fun saveSettingled(checked : Boolean)
    {
        context.dataStore.edit {
            it[Led_Turn] = checked
        }
    }
    val gettingled: Flow<Boolean> = context.dataStore.data.map {
        preferences ->
            preferences[Led_Turn]?:false
    }
}