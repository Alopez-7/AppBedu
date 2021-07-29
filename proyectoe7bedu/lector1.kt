package com.example.proyectoe7bedu

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

//se modificaron ambos build.gradle, tambien androidManifest.xml
//permite seleccionar el archivo de la biblioteca del telefono
//solo pdf

class lector1 : AppCompatActivity() {
    lateinit var bInterna: Button

    companion object {
        private val PICK_PDF_CODE = 1000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lector1)

        bInterna = findViewById(R.id.bInterna)

        bInterna.setOnClickListener {
            val pdfIntent = Intent(Intent.ACTION_GET_CONTENT)
            pdfIntent.type = "application/pdf"
            pdfIntent.addCategory(Intent.CATEGORY_OPENABLE)
            startActivityForResult(Intent.createChooser(pdfIntent, "Escoge PDF"), PICK_PDF_CODE)
        }
    }

    //ctrl=O para mostrar las opciones
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_PDF_CODE && resultCode == Activity.RESULT_OK && data != null) {
            val selectedPDF = data.data
            val intent = Intent(this@lector1, viewDoc::class.java)
            intent.putExtra("ViewType", "storage")
            intent.putExtra("FileUri", selectedPDF.toString())
            startActivity(intent)
        }
    }
}