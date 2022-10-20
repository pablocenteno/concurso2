package com.example.concurso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class DisplayMessageActivity2 : AppCompatActivity() {
    lateinit var opcion: CheckBox
    lateinit var opcion2: CheckBox
    lateinit var opcion3: CheckBox
    lateinit var nombre: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message2)

        nombre = intent.getStringExtra("nombre").toString()
        var mostrarNombre = findViewById<TextView>(R.id.nombrecete)
        mostrarNombre.setText(nombre)


        opcion=findViewById<CheckBox>(R.id.checkbox)
        opcion2=findViewById<CheckBox>(R.id.checkbox2)
        opcion3=findViewById<CheckBox>(R.id.checkbox3)
    }
    fun opciones(view: View)
    {
        if(opcion.isChecked){
            cont1 += 10
            siguiente(view)
        }
        else if(opcion2.isChecked){
            cont1 += 20
            siguiente(view)
        }
        else if(opcion3.isChecked){
            cont1 += 40
            siguiente(view)
        }
        else if(opcion.isChecked and opcion2.isChecked)
        {
            MaterialAlertDialogBuilder(this)
                .setTitle("Error")
                .setMessage("Elige una opcion")
                .setCancelable(true)
                .show()
        }
        else if(opcion.isChecked and opcion3.isChecked)
        {
            MaterialAlertDialogBuilder(this)
                .setTitle("Error")
                .setMessage("Elige una opcion")
                .setCancelable(true)
                .show()
        }
        else if(opcion2.isChecked and opcion3.isChecked)
        {
            MaterialAlertDialogBuilder(this)
                .setTitle("Error")
                .setMessage("Elige una opcion")
                .setCancelable(true)
                .show()
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

    fun siguiente(view: View){
         intent= Intent(this, DisplayMessageActivity3::class.java).apply {
            putExtra("cont1",cont1)
            putExtra("nombre", nombre)
        }
        startActivity(intent)
    }
}