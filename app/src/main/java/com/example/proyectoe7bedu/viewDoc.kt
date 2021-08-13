/*
ketzalli/Alejandro
descripcion: activity encargada de visualizar el pdf seleccionado de la biblioteca,
permite la lectura del documento, hacer zoom, desplazamiento entre paginas, editar propiedades del
documento como lo es el marcado como favorito, cambiar autor, coleccion y
serie, etc
*/

package com.example.proyectoe7bedu

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.barteksc.pdfviewer.PDFView


var dialog = CustomDialogFragment()
var ultimaPag: Int = 0
var indexArchivo = 0
var actualPage = 0

class viewDoc : AppCompatActivity() {

    lateinit var pdf_view: PDFView
    lateinit var pA: TextView
    lateinit var pT: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_doc)

        var titulo = intent.extras!!.getString("titulo")
        pdf_view = findViewById(R.id.pdf_view)


        data.forEach {if(it.titulo == titulo){
            indexArchivo = data.indexOf(it)
        }
        }
        data[indexArchivo].estatus = "Leyendo"


        pA = findViewById(R.id.pagAct)
        pT = findViewById(R.id.pagTot)

        //definicion del funcionamiento del lector (https://github.com/barteksc/AndroidPdfViewer.git)
        pdf_view.fromAsset("book/${titulo}")
            .defaultPage(ultimaPag)//para poner la ultima pagina leida
            .enableSwipe(true)
            .swipeHorizontal(false)
            .enableDoubletap(true)
            .onPageChange { page, pageCount ->
                pT.setText("$pageCount")
            }
            .onPageScroll { page, positionOffset -> //lista la pagina actual
                ultimaPag = page //mandar esto al registro
                pA.setText("$page")
                data[indexArchivo].actualPage = "${pA.text.toString()}/${pT.text.toString()}"
            }
            .onPageError { page, t ->
                Toast.makeText(this@viewDoc, "Error al abrir" + page, Toast.LENGTH_SHORT).show()
                Log.d("ERROR", "" + t.localizedMessage);
            }
            .load()
    }

    override fun onStop() {
        super.onStop()


    }

    //definicion del funcionamiento del menu
    //se cambio el action mode por que no se logro el uso del dialog fragment
    //cada item del menu permite abrir el dialog fragment que editaria la propiedad
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.favorito -> {
                Toast.makeText(this, "se agrego a favoritos", Toast.LENGTH_SHORT).show()
                data[indexArchivo].favorito = true
                return true
            }
            R.id.autor -> {
                fragmentSelected= 1
                Toast.makeText(this, "cambiar autor", Toast.LENGTH_SHORT).show()
                dialog.show(supportFragmentManager, "CustomDialog")



                return true
            }
            R.id.coleccion -> {
                fragmentSelected= 2
                Toast.makeText(this, "cambiar coleccion", Toast.LENGTH_SHORT).show()
                dialog.show(supportFragmentManager, "CustomDialog")
                return true
            }
            R.id.estatus -> {
                fragmentSelected= 3
                Toast.makeText(this, "cambiar estatus", Toast.LENGTH_SHORT).show()
                dialog.show(supportFragmentManager, "CustomDialog")
                return true
            }
            R.id.serie -> {
                fragmentSelected= 4
                Toast.makeText(this, "cambiar serie", Toast.LENGTH_SHORT).show()
                dialog.show(supportFragmentManager, "CustomDialog")
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}

