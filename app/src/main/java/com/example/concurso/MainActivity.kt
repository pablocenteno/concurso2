package com.example.concurso

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity

var cont1 = 0
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun siguiente(view: View){
         var texto= findViewById<EditText>(R.id.name)

        var nombre = texto.text.toString()

        intent = Intent(this, DisplayMessageActivity::class.java).apply {
                putExtra("nombre", nombre)

            }
            startActivity(intent)
    }

    fun borrado(view: View){
        var texto = findViewById<EditText>(R.id.name)
        texto.setText("")
    }


}






