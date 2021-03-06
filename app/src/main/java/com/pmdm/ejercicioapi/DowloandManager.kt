package com.pmdm.ejercicioapi

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class DowloandManager {

    companion object {

        var listaLibros = mutableListOf<Books>()
        lateinit var libro : String

        suspend fun downloadApiResults(): MutableList<Books>? {
            val client = OkHttpClient()
            val url = "https://www.anapioficeandfire.com/api/books"
            val request = Request.Builder()
                .url(url)
                .build()
            val call = client.newCall(request)
            val exc = call.execute()


            val bodyInString = exc.body?.string()
            bodyInString?.let {
                Log.w("GetAllFilms", bodyInString)
                val results = JSONArray(bodyInString)

                results.let {
                    Log.w("GetAllFilms", results.toString())
                    val gson = Gson()

                    val itemType = object : TypeToken<List<Books>>() {}.type

                    val list = gson.fromJson<List<Books>>(results.toString(), itemType)
                    delay(3000)
                    listaLibros = list as MutableList<Books>
                }
            }
            return listaLibros
        }

        suspend fun downloadApiSingleResult(userChoice: String): String {
            val client = OkHttpClient()
            var url = "https://www.anapioficeandfire.com/api/books"
            when (userChoice) {
                "1" -> url += "/1"
                "2" -> url += "/2"
                "3" -> url += "/3"
                "4" -> url += "/4"
                "5" -> url += "/5"
                "6" -> url += "/6"
                "7" -> url += "/7"
                "8" -> url += "/8"
                "9" -> url += "/9"
                "10" -> url += "/10"
                "11" -> url += "/11"
                "12" -> url += "/12"
                else -> return "No hay ningún libro con ese id. Prueba otro inferior"
            }
            val request = Request.Builder()
                .url(url)
                .build()
            val call = client.newCall(request)
            val exc = call.execute()

            delay(3000)
            val bodyInString = exc.body?.string()
            bodyInString?.let {
                Log.w("GetOneBook", bodyInString)
                delay(3000)
                libro = bodyInString
            }
            return libro
        }
    }

}