package com.pmdm.ejercicioapi

import android.graphics.Color
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class StringAdapter (var listaString : MutableList<Books>) : RecyclerView.Adapter<StringAdapter.StringViewHolder>() {
    class StringViewHolder(var root: View, var textView: TextView) : RecyclerView.ViewHolder(root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        val twTextView = view.findViewById<TextView>(R.id.textView)
        return StringViewHolder(view, twTextView)
    }

    override fun getItemCount(): Int {
        return listaString.size
    }

    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        for(i in listaString){
            holder.textView.text = i.toString()
        }

    }




}