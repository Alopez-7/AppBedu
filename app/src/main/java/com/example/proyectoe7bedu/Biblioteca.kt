//alejandro y andrea
package com.example.proyectoe7bedu

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.view.ActionMode
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
var data = mutableListOf(
Archive("","","",""))
var index= mutableListOf(0)
lateinit var dataHandler: RecyclerDataHandler
var dataChanged = false


class Biblioteca : AppCompatActivity(),RecyclerAdapter.OnItemClickListener,RecyclerAdapter.OnItemLongClickListener {
    lateinit var recycler: RecyclerView



    private var actionMode: ActionMode? = null
    private var adapter = RecyclerAdapter(data, this, this)

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biblioteca)


        val menuH = findViewById<Button>(R.id.MHButton)


        var sortSwitch = findViewById<Switch>(R.id.switchToggle)
        recycler = findViewById<RecyclerView>(R.id.recycler)

        recycler.adapter = adapter



        var archiveNameList = mutableListOf<String>()
        var archiveTypeList = mutableListOf<String>()

        assets.list("book")?.forEach {
            archiveNameList.add(it.substring(0, it.length - 4))
            archiveTypeList.add(it.substring(it.length - 4, it.length))

        }

        dataHandler = RecyclerDataHandler(data)
        dataHandler.populateData(archiveNameList, archiveTypeList)

        menuH.setOnClickListener {
            val intento1 = Intent(this, MenuHamburguesa::class.java)
            startActivity(intento1)
        }

    }

    override fun onItemLongClick(position: Int) {

        if (actionMode == null) actionMode = startSupportActionMode(ActionModeCallBack())
        dataHandler.showCheckBox()
        /*data.forEach {
            it.checkedDisabled = false
            it.checked=false}*/
        adapter.notifyDataSetChanged()
        true
    }

    override fun onItemClick(position: Int) {
        var intento1 = Intent(this, viewDoc::class.java)
        intento1.putExtra(
            "titulo",
            data[position].pathname
        )
        startActivity(intento1)
    }

    inner class ActionModeCallBack() : ActionMode.Callback {
        override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            val inflater = mode?.menuInflater
            inflater?.inflate(R.menu.action_mode_biblioteca, menu)
            mode?.title = ""
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            return true
        }

        override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
            when (item?.itemId) {

                //DELETE ACTION MENU
                R.id.actionMenuDelete -> {
                    mode?.title = "Delete"
                    var elementIndex = mutableListOf<Int>()

                    if (data.any { it.checked }) {
                        data.forEach {
                            if (it.checked) {
                                elementIndex.add(data.indexOf(it))
                            }
                        }
                        elementIndex.sortDescending()
                        elementIndex.forEach {
                            var i = it
                            data.removeAt(i)
                            adapter.notifyItemRemoved(i)
                        }
                        dataHandler.hideCheckbox()
                        dataChanged = true

                    }
                    adapter.notifyItemRangeChanged(0, data.size)
                    actionMode?.finish()
                    return true

                }

                //FAV ACTION MENU
                R.id.actionMenuFavorite -> {
                    mode?.title = ""
                    var elementIndex = mutableListOf<Int>()
                    if (data.any { it.checked }) {
                        data.forEach {
                            if (it.checked) {
                                elementIndex.add(data.indexOf(it))
                            }
                        }
                        elementIndex.sortDescending()
                        elementIndex.forEach {
                            var i = it
                            data[i].fav = true

                        }
                        dataHandler.hideCheckbox()
                        dataChanged = true

                    }
                    adapter.notifyDataSetChanged()
                    //Toast.makeText(parent,"Se agregaron a favoritos",Toast.LENGTH_SHORT).show()
                    actionMode?.finish()

                    return true
                }
                else -> {

                    return true
                }
            }
        }

        override fun onDestroyActionMode(mode: ActionMode?) {
            actionMode = null
            if (dataChanged) {
                dataHandler.hideCheckbox()
                adapter.notifyItemRangeChanged(0, data.size)
                dataChanged = false
            } else {
                dataHandler.hideCheckbox()
                adapter.notifyDataSetChanged()
            }


        }
    }
}