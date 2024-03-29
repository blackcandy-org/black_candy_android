package org.blackcandy.android.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class PreferencesDataSource(
    private val dataStore: DataStore<Preferences>,
) {
    companion object {
        private val SERVER_ADDRESS_KEY = stringPreferencesKey("server_address")
    }

    suspend fun getServerAddress(): String {
        return dataStore.data.first()[SERVER_ADDRESS_KEY] ?: ""
    }

    suspend fun updateServerAddress(serverAddress: String) {
        dataStore.edit { it[SERVER_ADDRESS_KEY] = serverAddress }
    }

    fun getServerAddressFlow(): Flow<String> {
        return dataStore.data.map { it[SERVER_ADDRESS_KEY] ?: "" }
    }
}
