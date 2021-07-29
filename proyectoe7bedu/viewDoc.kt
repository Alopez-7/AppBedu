package com.example.proyectoe7bedu

import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.github.barteksc.pdfviewer.PDFView

//ingresa a la visualizacion del lector permitiendo leer el documento escogido
class viewDoc : AppCompatActivity() {
    lateinit var pdf_view: PDFView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_doc)

        pdf_view = findViewById(R.id.pdf_view)

        if (intent != null) {
            val viewType = intent.getStringExtra("ViewType")
            if (!TextUtils.isEmpty(viewType) || viewType != null) {
                if (viewType.equals("storage")) {
                    val selectedPdf = Uri.parse(intent.getStringExtra("FileUri"))

                    pdf_view.fromUri(selectedPdf)
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
                }
            }
        }

    }
}