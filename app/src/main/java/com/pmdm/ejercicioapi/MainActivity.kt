package com.pmdm.ejercicioapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pmdm.ejercicioapi.databinding.ActivityMainBinding
import java.util.*
import kotlinx.coroutines.*



class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private lateinit var model : MainActivityViewModel
    private var adapter = AdapterString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)
        model = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        GlobalScope.launch{
           var resultados = model.getApiResults()
            adapter.setData(resultados)
        }


        //Poner el adapter al recycler view

        setContentView(binding.root)

        CoroutineScope(Dispatchers.IO).launch{
            GetAllBooks.send(this@MainActivity)
        }
    }


}




