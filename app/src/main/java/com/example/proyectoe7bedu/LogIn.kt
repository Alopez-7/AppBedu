package com.example.proyectoe7bedu

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import com.google.android.material.button.MaterialButton

class LogIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        val username = findViewById<TextView>(R.id.username)
        val password = findViewById<TextView>(R.id.password);
        val message = findViewById<TextView>(R.id.failedLogin);


        val loginbtn = findViewById<MaterialButton>(R.id.loginbtn);

        loginbtn.setOnClickListener {

            if(Patterns.EMAIL_ADDRESS.matcher(username.text).matches()&&password.text.length>6){
                message.text =""
                message.isVisible = false

                val intento1 = Intent(this, Biblioteca::class.java)
                startActivity(intento1)
            }
            else{
                message.isVisible = true
                if(!Patterns.EMAIL_ADDRESS.matcher(username.text).matches()){
                    username.setBackgroundColor(Color.parseColor("#20FF0000"))
                    message.text = "El Correo no es valido, utilice un correo real"

                }
                if(password.text.length<=6){
                    password.setBackgroundColor(Color.parseColor("#20FF0000"))
                    message.text = "La contraseña no es valida, debe de tener minomo 7 carácteres"
                }
                if((!Patterns.EMAIL_ADDRESS.matcher(username.text).matches())&&!(password.text.length>6))
                    message.text = "El correo y contraseña no son validos"

            }

        }


    }
}