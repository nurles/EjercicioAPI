package com.pmdm.ejercicioapi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class SecondActivityViewModel : ViewModel() {

    suspend fun getSingleItem(userChoice : String) : String{
        return withContext(Dispatchers.IO){
            val resultado = GlobalScope.async {
                DowloandManager.downloadApiSingleResult(userChoice)
            }
            resultado.await()
        }
    }
}