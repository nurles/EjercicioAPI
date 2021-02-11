package com.pmdm.ejercicioapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pmdm.ejercicioapi.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var model : MainActivityViewModel

    private var adapter = AdapterString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        model = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        createRecyclerView()

        GlobalScope.launch(Dispatchers.IO){
           val resultados : List<String> = listOf(model.getApiResults().toString())
            adapter.setData(resultados)
        }

        binding.recyclerView.setOnClickListener {
            SecondActivity.createSecondActivity(this)
        }

    }
    private fun createRecyclerView(){
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }


}




