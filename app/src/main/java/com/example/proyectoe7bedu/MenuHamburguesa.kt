package com.example.proyectoe7bedu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MenuHamburguesa : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var buttonEstatus: Button
    lateinit var buttonSerie: Button
    lateinit var buttonFavorito: Button
    lateinit var buttonColeccion: Button
    lateinit var buttonAutor: Button
    lateinit var buttonFormato: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_hamburguesa)

        textView = findViewById(R.id.textView)
        buttonEstatus = findViewById(R.id.buttonEstatus)
        buttonSerie = findViewById(R.id.buttonSerie)
        buttonFavorito = findViewById(R.id.buttonFavorito)
        buttonColeccion = findViewById(R.id.buttonColeccion)
        buttonAutor = findViewById(R.id.buttonAutor)
        buttonFormato = findViewById(R.id.buttonFormato)

        buttonEstatus.setOnClickListener {
            val intent = Intent(this, EstatusActivity::class.java)
            startActivity(intent)
        }

        buttonSerie.setOnClickListener {
            val intent = Intent(this, SerieActivity::class.java)
            startActivity(intent)
        }

        buttonFavorito.setOnClickListener {
            val intent = Intent(this, FavoritoActivity::class.java)
            startActivity(intent)
        }

        buttonColeccion.setOnClickListener {
            val intent = Intent(this, ColeccionActivity::class.java)
            startActivity(intent)
        }

        buttonAutor.setOnClickListener {
            val intent = Intent(this, AutorActivity::class.java)
            startActivity(intent)
        }

        buttonFormato.setOnClickListener {
            val intent = Intent(this, FormatoActivity::class.java)
            startActivity(intent)
        }

    }
}