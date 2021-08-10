//alejandro ->parte de biblioteca
package com.example.proyectoe7bedu

data class Archive (
    var name: String,
    var desciption: String,
    var type:String ="",
    var pathname:String= "",
    var icon: String="",
    var checkedDisabled: Boolean = true,
    var checked:Boolean = false,
    var fav:Boolean = false,
    var autor:String="Desconocido",
    var size:Float=0f,
    var paginas:Int=0,
    var resena:String="",
    var paginaActual:Int =0,
    var estatus:String="Pendiente"

)