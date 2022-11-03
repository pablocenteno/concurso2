package com.example.concurso.adapter

import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.concurso.Personaje
import com.squareup.picasso.Picasso
import com.example.concurso.R
import java.io.File

class PersonajeViewHolder(view:View):RecyclerView.ViewHolder(view) {

    val personaje = view.findViewById<TextView>(R.id.nombrePersonaje)
    val jugador = view.findViewById<TextView>(R.id.nombre_jugador)
    var foto = view.findViewById<ImageView>(R.id.imageView2)



    fun render(personajeModel: Personaje){
        personaje.text = personajeModel.personaje
        jugador.text= personajeModel.jugador

        val route = personajeModel.jugador +personajeModel.puntos + ".jpg"

        val uri = File("/data/data/com.example.concurso/files/$route")

        val uriImage = Uri.fromFile(uri)

        Picasso.with(foto.context).load(uriImage).fit().centerCrop().into(foto)

    }
}