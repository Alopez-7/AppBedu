package com.example.proyectoe7bedu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isGone
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter(
    val archives: List<Archive>, val listener:OnItemClickListener,
    val longlistener: OnItemLongClickListener
) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.layout_archive_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {

        holder.checkbox.setOnCheckedChangeListener { _, isChecked ->
            if (position <= data.size-1) {
                data[position].checked = isChecked
            }
            true
        }
        /*holder.itemView.setOnLongClickListener {
            if (actionMode == null) actionMode = startSupportActionMode(ActionModeCallBack())
            true
        }*/
        val archives = archives[position]
        holder.bind(archives)
    }


    override fun getItemCount(): Int {
        return archives.size
    }
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener, View.OnLongClickListener {
        val name = view.findViewById<TextView>(R.id.itemName)
        val description = view.findViewById<TextView>(R.id.itemDescription)
        val checkbox: CheckBox = view.findViewById(R.id.itemCheckBox)
        val img: ImageView = view.findViewById(R.id.ItemImage)


        fun bind(archive: Archive) {
            name.text = archive.name
            description.text = archive.desciption
            checkbox.isGone = archive.checkedDisabled
            checkbox.isChecked = archive.checked


        }
        init {
            view.setOnClickListener(this)
            view.setOnLongClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = absoluteAdapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }

        override fun onLongClick(v: View?): Boolean {
            val position: Int = absoluteAdapterPosition
            if (position != RecyclerView.NO_POSITION) {
                longlistener.onItemLongClick(position)
            }
            return true
        }

    }
    interface  OnItemClickListener{
        fun onItemClick(position:Int)
    }
    interface OnItemLongClickListener{
        fun onItemLongClick(position:Int)
    }


}

