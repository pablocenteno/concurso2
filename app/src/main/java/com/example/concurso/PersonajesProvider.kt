package com.example.concurso

import android.content.Context
import java.io.BufferedReader
import java.io.File
import android.os.Environment
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.*

class PersonajesProvider {


    fun fillList(): ArrayList<Personaje>
    {
        val listaPuntuacion: ArrayList<Personaje> = ArrayList<Personaje>()
        val ficheroCsv = File("/data/data/com.example.concurso3/files/puntuaciones.csv")

        val bufferedReader = BufferedReader(FileReader(ficheroCsv))
        val csvParser = CSVParser(bufferedReader, CSVFormat.DEFAULT);
        for (csvRecord in csvParser)
        {
            val nombre = csvRecord[0]
            val nombre_fichero = csvRecord[1]
            listaPuntuacion.add(Player(nombre, nombre_fichero))
        }

        return listaPuntuacion
    }
}
}