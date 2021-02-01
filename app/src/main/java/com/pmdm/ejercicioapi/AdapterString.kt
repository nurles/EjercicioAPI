package com.pmdm.ejercicioapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AdapterString : RecyclerView.Adapter<AdapterString.LibrosViewHolder>(){

    private var datos : List<String>? = null
    class LibrosViewHolder(root : View,val textView : TextView) : RecyclerView.ViewHolder(root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibrosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        val textView = view.findViewById<TextView>(R.id.textView)
        return LibrosViewHolder(view, textView)
    }

    override fun onBindViewHolder(holder: LibrosViewHolder, position: Int) {
        datos?.let{
            holder.textView.text = it[position]
        }
    }

    override fun getItemCount(): Int {
        datos?.let{
            return it.size
        }
        return 0
    }


    suspend fun setData(string: List<String>){
        datos = string
        withContext(Dispatchers.IO){
            notifyDataSetChanged()
        }

    }
}