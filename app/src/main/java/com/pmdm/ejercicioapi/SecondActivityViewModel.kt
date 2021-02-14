package com.pmdm.ejercicioapi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class SecondActivityViewModel : ViewModel() {

    suspend fun getSingleItem(userChoice : String) : String{
        delay(5000)
        return DowloandManager.downloadApiSingleResult(userChoice)


    }
}