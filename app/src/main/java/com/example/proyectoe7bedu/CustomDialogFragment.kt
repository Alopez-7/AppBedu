//ketzalli ->parte del lector
package com.example.proyectoe7bedu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
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
        val ingreso=rootView.findViewById<EditText>(R.id.intext)
        cancelButton.setOnClickListener{
            dismiss()
        }

        acceptButton.setOnClickListener{
            Toast.makeText(context,"valor cambiado a: ${ingreso.getText().toString()}",Toast.LENGTH_LONG).show()
            dismiss()
        }

        return rootView
    }

}
