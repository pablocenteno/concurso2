package com.example.concurso

import android.content.Context
import java.io.BufferedReader
import java.io.File
import android.os.Environment

import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.*


class PersonajesProvider {

    companion object {
        private lateinit var context:Context
        fun setContext(contexto:Context)
        {
            context=contexto
        }

        fun fillList(): ArrayList<Personaje> {
            val listaPuntuacion: ArrayList<Personaje> = ArrayList<Personaje>()
            val ficheroCsv = File("/data/data/com.example.concurso/files/puntos4.csv")

            val bufferedReader = BufferedReader(FileReader(ficheroCsv))
            val csvParser = CSVParser(bufferedReader, CSVFormat.DEFAULT)
            for (csvRecord in csvParser) {
                val jugador = csvRecord[0]
                val puntos = csvRecord[1]
                val personaje = csvRecord[2]
                val foto=csvRecord[3]
                listaPuntuacion.add(Personaje(jugador, puntos, personaje, foto))
            }

            return listaPuntuacion
        }

    }
}
