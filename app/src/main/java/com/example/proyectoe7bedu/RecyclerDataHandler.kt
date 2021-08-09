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
    fun populateData(names:MutableList<String>,type:MutableList<String>){
        data.clear()
        names.forEach {
            var archive = Archive(it,"Lorem Ipsum dolor",type[names.indexOf(it)],it+type[names.indexOf(it)])
            data.add(archive)
        }
        data.forEach {
            when(it.type.toLowerCase()){
                ".txt"->{
                    it.icon ="@drawable/ic_pdf"
                }
                ".pdf"->{
                    it.icon ="@drawable/ic_txt"
                }
            }
        }

    }
}