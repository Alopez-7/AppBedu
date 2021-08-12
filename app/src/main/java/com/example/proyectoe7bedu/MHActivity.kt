//anthony, es un menu hamburguesa bonito pero no se puede implementar correctamente

package com.example.proyectoe7bedu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MHActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mh)

        val appBar = findViewById<Toolbar>(R.id.app_bar)
        this.setSupportActionBar(appBar)

        setupDrawer(appBar)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
        when (item.itemId) {
            R.id.nav_favorites -> {
                Toast.makeText(this, "Favorites", Toast.LENGTH_LONG).show()
                val intent = Intent(this, FavoritoActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.nav_status -> {
                Toast.makeText(this, "Estatus", Toast.LENGTH_LONG).show()
                val intent = Intent(this, EstatusActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.nav_authors -> {
                Toast.makeText(this, "Autores", Toast.LENGTH_LONG).show()
                val intent = Intent(this, AutorActivity::class.java)
                startActivity(intent)
                return true
            }R.id.nav_series -> {
            Toast.makeText(this, "Series", Toast.LENGTH_LONG).show()
            val intent = Intent(this, SerieActivity::class.java)
            startActivity(intent)
            return true
        }
            R.id.nav_collections -> {
                Toast.makeText(this, "Colecciones", Toast.LENGTH_LONG).show()
                val intent = Intent(this, ColeccionActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    private fun setupDrawer(toolbar: Toolbar){
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val drawerToggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer)
    }


}
