//angeles y ketzalli (solo detalles)
package com.example.proyectoe7bedu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.button.MaterialButton


class Bienvenida : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        val boton1=findViewById<MaterialButton>(R.id.buttonAccept)
        boton1.setOnClickListener {
            val intento1 = Intent(this, LogIn::class.java)
            startActivity(intento1)
        }
        val boton2=findViewById<MaterialButton>(R.id.poli_priv)
        boton2.setOnClickListener {
            val intento2 = Intent(this, Poli_Priva::class.java)
            startActivity(intento2)
        }
        val boton3=findViewById<MaterialButton>(R.id.ter_ser)
        boton3.setOnClickListener {
            val intento3 = Intent(this, Ter_Servicio::class.java)
            startActivity(intento3)
        }

    }
}
