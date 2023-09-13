package org.blackcandy.android.data

import org.blackcandy.android.api.BlackCandyService
import org.blackcandy.android.models.SystemInfo
import javax.inject.Inject

class SystemInfoRepository @Inject constructor(
    private val service: BlackCandyService,
) {
    suspend fun getSystemInfo(): SystemInfo {
        return service.getSystemInfo()
    }
}
