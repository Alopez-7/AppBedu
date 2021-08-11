
package com.example.proyectoe7bedu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class CustomDialogFragment: DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView:View=inflater.inflate(R.layout.fragment_custom_dialog1,container,false)
        val cancelButton=rootView.findViewById<Button>(R.id.cancelButton)
        val acceptButton=rootView.findViewById<Button>(R.id.acceptButton)
        cancelButton.setOnClickListener{
            dismiss()
        }

        acceptButton.setOnClickListener{
            //arreglar que cambie el valor de la propiedad
            Toast.makeText(context,"accion realizada",Toast.LENGTH_LONG).show()
            dismiss()
        }

        return rootView
    }

}
