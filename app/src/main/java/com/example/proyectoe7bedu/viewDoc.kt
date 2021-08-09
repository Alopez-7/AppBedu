package com.example.proyectoe7bedu

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ActionMode
import com.github.barteksc.pdfviewer.PDFView

//ingresa a la visualizacion del lector permitiendo leer el documento escogido
private var actionMode: ActionMode? = null

class viewDoc : AppCompatActivity() {
    lateinit var pdf_view: PDFView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_doc)

        var titulo = intent.extras!!.getString("titulo")
        pdf_view = findViewById(R.id.pdf_view)

        pdf_view.fromAsset(titulo)
            .password(null)
            .defaultPage(0)
            .enableSwipe(true)
            .swipeHorizontal(false)
            .enableDoubletap(true)
            .onDraw { canvas, pageWidth, pageHeight, displayPage ->
                //codigo aquiiii
            }
            .onDrawAll { canvas, pageWidth, pageHeight, displayedPage ->
                //y aquiiiii
            }
            .onPageChange { page, pageCount ->
                //tambien aquiiii <3
            }
            .onPageError { page, t ->
                Toast.makeText(this@viewDoc, "Error al abrir" + page, Toast.LENGTH_SHORT).show()
                Log.d("ERROR", "" + t.localizedMessage);
            }
            .onTap { false }
            .onRender { nbPages, pageWidth, pageHeight ->
                pdf_view.fitToWidth()//ajusta el tama;o de pantalla
            }
            .enableAnnotationRendering(true)
            .invalidPageColor(Color.RED)
            .load()


        pdf_view.setOnClickListener(){
            if (actionMode == null) actionMode =
                startSupportActionMode(ActionModeCallback())
            true
        }
    }

    class ActionModeCallback : ActionMode.Callback {
        override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            val inflater = mode?.getMenuInflater()
            inflater?.inflate(R.menu.action_mode, menu)
            mode?.setTitle("Options")
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            return true
        }

        override fun onDestroyActionMode(mode: ActionMode?) {
            actionMode = null
        }

        override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
            when (item?.getItemId()) {
                R.id.favorito -> {
                    //aqui accion
                    return true
                }
                R.id.autor -> {
                    //aqui accion
                    return true
                }
                R.id.coleccion -> {
                    //aqui accion
                    return true
                }
                R.id.estatus -> {
                    //aqui accion
                    return true
                }
                R.id.serie -> {
                    //aqui accion
                    return true
                }
            }
            return false
        }
    }
}