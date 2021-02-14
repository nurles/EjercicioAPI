package com.pmdm.ejercicioapi

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.pmdm.ejercicioapi.databinding.ActivitySecondBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//Parentesis extends de java, sin parentesis implement
class SecondActivity : AppCompatActivity(){

    private lateinit var binding : ActivitySecondBinding
    private lateinit var model : SecondActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        model = ViewModelProvider(this).get(SecondActivityViewModel::class.java)
        var valor =  intent.getStringExtra(TAG)
        GlobalScope.launch(Dispatchers.IO) {
            val resultado = valor?.let { it1 -> model.getSingleItem(it1) }
            withContext(Dispatchers.Main){
                binding.textViewResultado.text =  resultado
            }
        }


    }

    companion object{
        private const val TAG = "TAG"
        fun createSecondActivity(context: Context, valor: String){
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra(TAG, valor)
            context.startActivity(intent)
        }
    }
}