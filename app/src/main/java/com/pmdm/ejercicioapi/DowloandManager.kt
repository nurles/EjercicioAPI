package com.pmdm.ejercicioapi

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class DowloandManager {

    companion object {
        suspend fun downloadApiResults(): List<String> {
            val client = OkHttpClient()
            val url = "https://www.anapioficeandfire.com/api/books"
            val request = Request.Builder()
                    .url(url)
                    .build()
            val response = client.newCall(request).execute()
            if(!response.isSuccessful){
                println("Error en la llamada")
            }
            val responseHeaders = response.headers

            delay(3000)
            return listOf(response.toString())

        }

        suspend fun downloadApiSingleResult(userChoice: String): String {
            val client = OkHttpClient()
            val url = "https://www.anapioficeandfire.com/api/books"
            val request = Request.Builder()
                    .url(url)
                    .build()
            val response = client.newCall(request).execute()
            if(!response.isSuccessful){
                println("Error en la llamada")
            }
            val responseHeaders = response.headers
            delay(3000)
            return when (userChoice) {
                "1" -> "1"
                "2" -> "2"
                else -> "OTROS RESULTADOS"
            }

        }
    }
}