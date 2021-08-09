package com.example.proyectoe7bedu

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import com.google.android.material.snackbar.Snackbar

var libros = mutableListOf("Trono de cristal", "Tokyo Blues", "Inferno", "Corona de Medianoche","Heredero de Fuego","Reina de Sombras","Kafka en la orilla", "The Eternal Ones","Thus Spoke Zarathustra","Demian",
    "Los hijos de Hurin","Test1","Test2","Test3","Test4")

class Biblioteca : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biblioteca)

        var bookAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1, libros)
        var menuH = findViewById<Button>(R.id.MHButton)
        var lector=findViewById<Button>(R.id.botonLector)
        var sortSwitch = findViewById<Switch>(R.id.switchToggle)
        var librosList = findViewById<ListView>(R.id.bookList)
        var bookslist = libros

        bookAdapter =
            ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1, libros)
        librosList.adapter = bookAdapter


        sortSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                libros.sort()
                bookAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1, libros)
                librosList.adapter = bookAdapter

                // Change the app background color

            } else {
                libros.shuffle()
                bookAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1, libros)
                librosList.adapter = bookAdapter

            }
        }


        librosList.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                Toast.makeText(
                    applicationContext,
                    "Abriendo ${libros[position]}",
                    Toast.LENGTH_SHORT
                ).show()

            }

        librosList.onItemLongClickListener =
            AdapterView.OnItemLongClickListener { parent, view, position, id ->

                Snackbar.make(parent, "Borrar ${libros[position]}", Snackbar.LENGTH_LONG)
                    .setAction("Delete") {
                        libros.removeAt(position)
                        bookAdapter = ArrayAdapter<String>(
                            this,
                            android.R.layout.simple_list_item_activated_1,
                            libros
                        )
                        librosList.adapter = bookAdapter
                    }
                    .setBackgroundTint(getColor(R.color.black))
                    .setActionTextColor(getColor(android.R.color.holo_orange_light))
                    .show()

                true

            }

        menuH.setOnClickListener {
            val intento1 = Intent(this, MenuHamburguesa::class.java)
            startActivity(intento1)
        }
        lector.setOnClickListener {
            var intento1 = Intent(this, viewDoc::class.java)
            intento1.putExtra("titulo","Dracula - Bram Stoker.pdf")//cambiar el titulo del libro por una variable string que contenga el nombre del asset
            startActivity(intento1)
        }

    }
}