package org.blackcandy.android.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.runBlocking
import org.blackcandy.android.data.ServerAddressRepository

class HomeViewModel(
    private val serverAddressRepository: ServerAddressRepository,
) : ViewModel() {
    val serverAddress =
        runBlocking {
            serverAddressRepository.getServerAddress()
        }
}
