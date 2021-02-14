package com.pmdm.ejercicioapi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class MainActivityViewModel : ViewModel() {

    suspend fun getApiResults() : MutableList<Books>? {
        delay(5000)
        return DowloandManager.downloadApiResults()
    }
}