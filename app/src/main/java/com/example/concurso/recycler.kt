package com.example.concurso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.concurso.adapter.PersonajeAdapter
import com.example.concurso.PersonajesProvider
class recycler : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        initRecyclerView()
    }

    fun initRecyclerView()
    {
        val recyclerView= findViewById<RecyclerView>(R.id.recyclerPlayer)

        recyclerView.layoutManager= LinearLayoutManager(this)

        val personajesProvider = PersonajesProvider
        personajesProvider.setContext(this)

        recyclerView.adapter = PersonajeAdapter(personajesProvider.fillList())
    }
}