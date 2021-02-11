package com.pmdm.ejercicioapi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class MainActivityViewModel : ViewModel() {

    suspend fun getApiResults() {
        return withContext(Dispatchers.IO) {
            val resultado : Deferred<List<Books>?> = GlobalScope.async {
                DowloandManager.downloadApiResults()
            }
            resultado.await()
        }
    }
}