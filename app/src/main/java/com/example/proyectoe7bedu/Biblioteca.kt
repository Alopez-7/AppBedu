package com.example.proyectoe7bedu

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.view.ActionMode
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoe7bedu.Archive
import com.example.proyectoe7bedu.MenuHamburguesa
import com.example.proyectoe7bedu.R
import com.example.proyectoe7bedu.viewDoc
import com.google.android.material.snackbar.Snackbar

var index= mutableListOf(0)
lateinit var dataHandler: RecyclerDataHandler
var dataChanged = false
var blockedClick = false
lateinit var localData:MutableList<Archive>

class Biblioteca : AppCompatActivity(),RecyclerAdapter.OnItemClickListener,RecyclerAdapter.OnItemLongClickListener {
    lateinit var recycler: RecyclerView



    private var actionMode: ActionMode? = null
    private var adapter = RecyclerAdapter(data, this, this)

    @SuppressLint("RestrictedApi")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biblioteca)
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)

        var menuH = findViewById<Button>(R.id.MHButton)
        var sortSwitch = findViewById<Switch>(R.id.switchToggle)
        recycler = findViewById<RecyclerView>(R.id.recycler)

        recycler.adapter = adapter
        dataHandler = RecyclerDataHandler(data)

        localData = mutableListOf(Archive())

        recycler.apply {

            val topSpacingDecorator = BibliotecaRecyclerDecoration(10)
            addItemDecoration(topSpacingDecorator)

        }


        menuH.setOnClickListener {
            localData.clear()
            localData.addAll(data)
            var elementIndex = mutableListOf<Int>()
            if (data.any { it.favorito }) {
                data.forEach {
                    if (!it.favorito) {
                        elementIndex.add(data.indexOf(it))
                    }
                }
                elementIndex.sortDescending()
                elementIndex.forEach {
                    var i = it
                    data.removeAt(i)
                    adapter.notifyItemRemoved(i)
                }
            }
        }
        sortSwitch.setOnCheckedChangeListener { _, isChecked ->
            data.clear()
            data.addAll(localData)
            adapter.notifyItemRangeChanged(0, data.size)

        }




    }

    override fun onItemLongClick(position: Int) {


        if (actionMode == null) actionMode = startSupportActionMode(ActionModeCallBack())
        dataHandler.showCheckBox()
        adapter.notifyItemRangeChanged(0, data.size)

        true
    }

    override fun onItemClick(position: Int) {
        if(!blockedClick) {
            var intento1 = Intent(this, viewDoc::class.java)

            intento1.putExtra(
                "titulo",
                data[position].titulo
            )
            startActivity(intento1)
        }

    }

    inner class ActionModeCallBack() : ActionMode.Callback {
        override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            val inflater = mode?.menuInflater
            inflater?.inflate(R.menu.action_mode_biblioteca, menu)
            mode?.title = ""
            blockedClick = true

            return true
        }

        override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            return true
        }

        override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
            when (item?.itemId) {

                //DELETE ACTION MENU
                R.id.actionMenuDelete -> {

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
                            data[i].favorito = true

                        }
                        dataHandler.hideCheckbox()
                        dataChanged = true

                    }
                    adapter.notifyDataSetChanged()
                    blockedClick = false
                    actionMode?.finish()

                    return true
                }
                R.id.actionMenuSort -> {
                    data.sortBy { it.titulo.toLowerCase() }
                    dataChanged = true
                    adapter.notifyDataSetChanged()
                    blockedClick = false
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
                blockedClick = false
            } else {
                dataHandler.hideCheckbox()
                adapter.notifyDataSetChanged()
                blockedClick = false
            }
        }
    }

}