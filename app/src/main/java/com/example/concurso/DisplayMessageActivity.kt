package com.example.concurso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import android.widget.EditText
import androidx.activity.ComponentActivity


class DisplayMessageActivity : AppCompatActivity() {

    lateinit var opcion: RadioButton
    lateinit var opcion2: RadioButton
    lateinit var opcion3: RadioButton
    lateinit var nombre: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        opcion = findViewById<RadioButton>(R.id.radioButton)
        opcion2 = findViewById<RadioButton>(R.id.radioButton2)
        opcion3= findViewById<RadioButton>(R.id.radioButton3)

        // Get the Intent that started this activity and extract the string
        nombre = intent.getStringExtra("nombre").toString()

         //Capture the layout's TextView and set the string as its text
       var mostrarNombre = findViewById<TextView>(R.id.textView4)

        mostrarNombre.setText(nombre)
    }
    fun opciones(view: View)
    {
        if(opcion.isChecked){

            cont1 += 10
            sendMessage(view)
        }
        else if(opcion2.isChecked){
            cont1 += 20
            sendMessage(view)
        }
        else if(opcion3.isChecked){
            cont1 += 40
            sendMessage(view)
        }
        else
        {
            MaterialAlertDialogBuilder(this)
                .setTitle("Error")
                .setMessage("Elige una opcion")
                .setCancelable(true)
                .show()
        }
    }

    fun sendMessage( view: View){

        intent= Intent(this, DisplayMessageActivity2::class.java).apply {

            putExtra("nombre", nombre)
            putExtra("cont1",cont1)

        }
        startActivity(intent)
    }
}