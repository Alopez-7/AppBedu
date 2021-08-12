//alejandro ->parte de biblioteca
package com.example.proyectoe7bedu

class RecyclerDataHandler (data:MutableList<Archive>) {
    fun hideCheckbox(){
        data.forEach {
            it.checked=false
            it.checkedDisabled=true
        }
    }
    fun showCheckBox(){
        data.forEach {
            it.checkedDisabled=false
        }
    }

}