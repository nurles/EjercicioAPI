package com.pmdm.ejercicioapi

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.pmdm.ejercicioapi.databinding.ActivityMainBinding
import com.pmdm.ejercicioapi.databinding.ActivitySecondBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SecondActivity : AppCompatActivity(){

    private lateinit var binding : ActivitySecondBinding
    private lateinit var model : SecondActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        model = ViewModelProvider(this).get(SecondActivityViewModel::class.java)

        binding.botonBuscar.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                val resultado = model.getSingleItem(binding.editTextSecond.text.toString())
                withContext(Dispatchers.Main){
                    binding.textViewResultado.text =  resultado.toString()
                }
            }
        }

    }

    companion object{

        fun createSecondActivity(context : Context){
            val intent = Intent(context, SecondActivity::class.java)
            context.startActivity(intent)
        }
    }
}