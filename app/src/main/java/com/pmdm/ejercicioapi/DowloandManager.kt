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
            val call = client.newCall(request)
            val exc = call.execute()

            delay(3000)
            return listOf(exc.body.toString())

        }

        suspend fun downloadApiSingleResult(userChoice: String): String {
            val client = OkHttpClient()
            var url = "https://www.anapioficeandfire.com/api/books"
            when (userChoice) {
                "1" -> url+="/1"
                "2" -> url+="/2"
                "3" -> url+="/3"
                "4" -> url+="/4"
                "5" -> url+="/5"
                "6" -> url+="/6"
                "7" -> url+="/7"
                "8" -> url+="/8"
                "9" -> url+="/9"
                "10"-> url+="/10"
                "11" -> url+="/11"
                "12" -> url+="/12"
                else -> "No hay ningún libro con ese id. Prueba otro inferior"
            }
            val request = Request.Builder()
                    .url(url)
                    .build()
            val call = client.newCall(request)
            val exc = call.execute()

            delay(3000)
            return exc.body.toString()

        }
    }
}