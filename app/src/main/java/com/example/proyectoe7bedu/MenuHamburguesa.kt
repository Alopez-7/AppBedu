//anthony y ketzalli (solo detalles)
package com.example.proyectoe7bedu

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MenuHamburguesa : AppCompatActivity() {
    lateinit var textView: TextView
    private lateinit var listView: ListView

    val op = arrayOf(
        "Favoritos",
        "Estatus",
        "Autores",
        "Series",
        "Colecciones"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listview_mh)

        listView = findViewById(R.id.listView)

        val itemsAdapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, op)

        listView.adapter = itemsAdapter

        listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                Toast.makeText(
                    applicationContext,
                    "Seleccionaste la opción ${op[position]}", Toast.LENGTH_SHORT
                )
                    .show()
                when (id.toInt()) {
                    0 -> {
                        val intent = android.content.Intent(this, FavoritoActivity::class.java)
                        startActivity(intent)
                    }
                    1 -> {
                        val intent = android.content.Intent(this, EstatusActivity::class.java)
                        startActivity(intent)
                    }
                    2 -> {
                        val intent = android.content.Intent(this, AutorActivity::class.java)
                        startActivity(intent)
                    }
                    3 -> {
                        val intent = android.content.Intent(this, SerieActivity::class.java)
                        startActivity(intent)
                    }
                    4 -> {
                        val intent = android.content.Intent(this, ColeccionActivity::class.java)
                        startActivity(intent)
                    }

                }
            }

    }
}