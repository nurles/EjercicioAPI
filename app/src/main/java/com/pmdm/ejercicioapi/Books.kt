package com.pmdm.ejercicioapi

import com.google.gson.annotations.SerializedName
import java.util.*

data class Books (
    var url : String,
    var name : String,
    var isbn : String,
    var authors: List<String>?,
    var numberPages : Int,
    var publiser : String,
    var country : String,
    var mediaType : String,
    var released : String,
    var characters : List<String>?

    )

{
    override fun toString(): String {
        return "Libro: $name\nAutor: $authors\nNúmero de páginas: $numberPages\nFecha publicación: $released"
    }
}