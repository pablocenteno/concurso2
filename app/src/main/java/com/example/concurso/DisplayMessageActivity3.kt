package com.example.concurso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView

class DisplayMessageActivity3 : AppCompatActivity() {
    lateinit var nombre: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message3)

        nombre = intent.getStringExtra("nombre").toString()
        var mostrarNombre = findViewById<TextView>(R.id.nombrecillo)
        mostrarNombre.setText(nombre)


        var spiner = findViewById<Spinner>(R.id.spinner)
        val opciones = resources.getStringArray(R.array.opciones)
        if (spiner != null) {
            var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opciones)
            spiner.adapter = adapter
        }
    }

    fun opciones(view: View) {

        var spiner = findViewById<Spinner>(R.id.spinner)
        val index = spiner.selectedItemPosition
        if (index == 0) {
            cont1 += 10
            siguiente(view)
        } else if (index == 1) {
            cont1 += 20
            siguiente(view)
        } else if (index == 2) {
            cont1 += 40
            siguiente(view)
        }
    }

    fun siguiente(view: View) {
        intent = Intent(this, DisplayMessageActivity4::class.java).apply {
            putExtra("cont1", cont1)
            putExtra("nombre", nombre)
        }
        startActivity(intent)
    }
}
