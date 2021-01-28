package com.pmdm.ejercicioapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.pmdm.ejercicioapi.databinding.ActivityMainBinding
import java.util.*
import kotlinx.coroutines.*

interface MainActivityInterface {
    suspend fun onBooksReceived(listaLibros : List<Books>)
}

class MainActivity : AppCompatActivity(), MainActivityInterface {
    private lateinit var adapter : StringAdapter
    private lateinit var binding : ActivityMainBinding
    companion object {
        private var listaLibrosString = mutableListOf<Books>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createRecyclerView()

        CoroutineScope(Dispatchers.IO).launch{
            GetAllBooks.send(this@MainActivity)
        }
    }
    private fun createRecyclerView() {
        adapter = StringAdapter(listaLibrosString)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    override suspend fun onBooksReceived(listaLibros: List<Books>) {
        withContext(Dispatchers.Main) {
            listaLibros.forEach {
                listaLibrosString.append(it.toString())
            }
        }
    }

}

private fun <E> MutableList<E>.append(toString: String) {

}


