package com.example.proyectoe7bedu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SerieActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serie)

        textView = findViewById(R.id.textSerie)
    }
}
