package com.pmdm.ejercicioapi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class MainActivityViewModel : ViewModel() {

    suspend fun getApiResults() : String{
        var resultado = GlobalScope.async{
            DowloandManager.downloadApiResults()
        }
        return resultado.await()
    }
}