/*
contribuye: ketzalli y andrea
descripcion: activity encargada de visualizar el pdf seleccionado de la biblioteca,
permite la lectura del documento, hacer zoom, desplazamiento entre paginas, editar propiedades del
documento como lo es el marcado como favorito, cambiar autor, coleccion y
serie, el estatus se cambia automaticamente
*/

package com.example.proyectoe7bedu

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.barteksc.pdfviewer.PDFView
import com.google.android.material.floatingactionbutton.FloatingActionButton


var dialog = CustomDialogFragment()
var ultimaPag: Int = 0

class viewDoc : AppCompatActivity() {

    lateinit var pdf_view: PDFView
    lateinit var pA:TextView
    lateinit var pT:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_doc)

        var titulo = intent.extras!!.getString("titulo")
        pdf_view = findViewById(R.id.pdf_view)
        pA=findViewById(R.id.pagAct)
        pT=findViewById(R.id.pagTot)

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
                pA.setText("$page")
                ultimaPag = page //mandar esto al registro
            }
            .onPageError { page, t ->
                Toast.makeText(this@viewDoc, "Error al abrir" + page, Toast.LENGTH_SHORT).show()
                Log.d("ERROR", "" + t.localizedMessage);
            }
            .load()
    }

//definicion del funcionamiento del menu
//se cambio el action mode por que no permitia el uso del dialog fragment
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.favorito -> {
                Toast.makeText(this, "agregar a favoritos", Toast.LENGTH_LONG).show()
                dialog.show(supportFragmentManager, "CustomDialog")
                return true
            }
            R.id.autor -> {
                Toast.makeText(this, "cambiar autor", Toast.LENGTH_LONG).show()
                dialog.show(supportFragmentManager, "CustomDialog")
                return true
            }
            R.id.coleccion -> {
                Toast.makeText(this, "cambiar coleccion", Toast.LENGTH_LONG).show()
                dialog.show(supportFragmentManager, "CustomDialog")
                return true
            }
            R.id.estatus -> {
                Toast.makeText(this, "cambiar estatus", Toast.LENGTH_LONG).show()
                dialog.show(supportFragmentManager, "CustomDialog")
                return true
            }
            R.id.serie -> {
                Toast.makeText(this, "cambiar serie", Toast.LENGTH_LONG).show()
                dialog.show(supportFragmentManager, "CustomDialog")
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}

