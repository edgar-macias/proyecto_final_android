package mx.emp.proyectofinal.model.entities

import java.io.Serializable

data class Animal(
    val name:String,
    val description:String,
    val uriImage:String,
    val peso:Double,
    val gender:Char
):Serializable
