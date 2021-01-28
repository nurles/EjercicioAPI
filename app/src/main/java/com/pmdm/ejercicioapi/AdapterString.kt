package com.pmdm.ejercicioapi

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdapterString : RecyclerView.Adapter<AdapterString.ViewHolder>(){

    private var datos : String? = null
    class LibrosViewHolder(root : View) : RecyclerView.Recycler.ViewHolder(root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibrosViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: LibrosViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    fun setData(string : String){
        datos = string
        notifyDataSetChanged()
    }
}