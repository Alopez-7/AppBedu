package com.example.proyectoe7bedu

data class Archive (
    var name: String,
    var desciption: String,
    var type:String ="",
    var pathname:String= "",
    var icon: String="",
    var checkedDisabled: Boolean = true,
    var checked:Boolean = false,
    var fav:Boolean = false

)