//angeles ->parte de bienvenida
package com.example.proyectoe7bedu

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
var data = mutableListOf(
    Archive("50 common english verbs - daniel welsch.pdf","Daniel Welsh","pdf"),
    Archive("60 adjetivos en ingles y español - daniel welsch.pdf","Daniel Welsh","pdf") ,
    Archive("como programar c, c++ y java - deitel y deitel.pdf","Deitel y Detiel","pdf"),
    Archive("como programar en java (7ma) - deitel y deitel.pdf","Deitel y Detiel","pdf"),
    Archive("Dracula - Bram Stoker.pdf","Bram Stoker","pdf"),
    Archive("guia revolucion mexicana - unam.pdf","UNAM","pdf"),
    Archive("Hamlet - William Shakespeare.pdf","William Shakespeare","pdf"),
    Archive("introduccion a la teoria de grafos - ekaterina zhukova.pdf","ekaterina zhukova","pdf"),
    Archive("Otome Game no Hametsu Flag - 01 [LN][Ferindrad].pdf","Satoru Yamaguchi","pdf"),
    Archive("Otome Game no Hametsu Flag - 02 [LN][Ferindrad].pdf","Satoru Yamaguchi","pdf")

)
var fragmentSelected = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            data.shuffle()
            val intent = Intent(this, Bienvenida::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}
