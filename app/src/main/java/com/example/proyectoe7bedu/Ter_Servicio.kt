package com.example.proyectoe7bedu

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Ter_Servicio : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ter_servicio)

        val botonsalir1 = findViewById<Button>(R.id.B_Salir2)
        botonsalir1.setOnClickListener {
            finish()
        }
    }


}

