package com.example.proyectoe7bedu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class Poli_Priva : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poli_priva)

        val botonsalir1 = findViewById<Button>(R.id.B_Salir)
        botonsalir1.setOnClickListener {
            finish()
        }
    }
}