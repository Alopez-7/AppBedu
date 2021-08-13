//alejandro ->parte de biblioteca
package com.example.proyectoe7bedu

data class Archive (
    var titulo:String= "",
    var autor:String= "",
    var formato:String ="",
    var estatus:String= "Pendiente",
    var contenido: String= "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum viverra hendrerit congue. Nulla mattis in purus eget facilisis. Sed eu dolor ex. Cras quis tellus et est fermentum porttitor at in mi. ",
    var serie:String=  "",
    var favorito:Boolean =false,
    var coleccion:String ="",
    var checked: Boolean =false,
    var checkedDisabled: Boolean = true,
    var actualPage:String = "0"
)