package com.pmdm.ejercicioapi

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterString : RecyclerView.Adapter<AdapterString.LibrosViewHolder>(){

    private var datos = mutableListOf<Books>()
    var posicionSeleccionado : Int = 0


    class LibrosViewHolder(val root : View, val textView : TextView) : RecyclerView.ViewHolder(root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibrosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        val textView = view.findViewById<TextView>(R.id.textView)
        return LibrosViewHolder(view, textView)
    }

    override fun onBindViewHolder(holder: LibrosViewHolder, position: Int) {
        datos?.let{
            holder.textView.text = it[position].toString()
        }

        //Solo vale para elegir con el teclado no con el raton
        holder.root.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus){
                holder.root.setBackgroundColor(Color.GRAY)
                posicionSeleccionado = position+1
            }else{
                holder.root.setBackgroundColor(Color.WHITE)
            }
        }
        holder.root.setOnClickListener{
            SecondActivity.createSecondActivity(it.context, posicionSeleccionado.toString())
        }
    }

    override fun getItemCount(): Int {
        datos?.let{
            return it.size
        }
        return 0
    }


    fun setData(booksList: MutableList<Books>){
        this.datos = booksList
        notifyDataSetChanged()


    }
}

