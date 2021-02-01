package com.pmdm.ejercicioapi

import kotlinx.coroutines.delay

class DowloandManager {

    companion object{
        suspend fun downloadApiResults() : List<String>{
            //Conexion internet
            //OkHttpClient()...
            delay(3000)
            return listOf("String 1","String 2","String 3", "String 4", "String 5", "String 6")
        }

        suspend fun downloadApiSingleResult(userChoice : String) : String{
            //Conexion internet
            //OkHttpClient()...
            delay(3000)
            return when(userChoice.length){
                1 -> "RESULTADO 1"
                2 -> "RESULTADO 2"
                else -> "OTROS RESULTADOS"
            }

        }
    }
}