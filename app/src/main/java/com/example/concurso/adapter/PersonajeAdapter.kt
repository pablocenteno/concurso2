package com.example.concurso.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concurso.Personaje
import com.example.concurso.R

class PersonajeAdapter(val listaPersonajes:List<Personaje>): RecyclerView.Adapter<PersonajeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajeViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return PersonajeViewHolder(layoutInflater.inflate(R.layout.foto, parent, false))
    }

    override fun onBindViewHolder(holder: PersonajeViewHolder, position: Int) {
        val item = listaPersonajes[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return listaPersonajes.size
    }


}