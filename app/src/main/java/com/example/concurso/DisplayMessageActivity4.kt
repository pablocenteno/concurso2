package com.example.concurso

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.text.SimpleDateFormat
import java.util.*

class DisplayMessageActivity4 : AppCompatActivity() {
    lateinit var nombre: String
    var captura_imagen=1
    lateinit var foto :ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message4)
        var personaje: TextView = findViewById(R.id.nombre)
        foto = findViewById(R.id.iv)

        nombre= intent.getStringExtra("nombre").toString()
        var mostrarNombre = findViewById<TextView>(R.id.textView5)
        mostrarNombre.setText(nombre)
        guardar()
        if(cont1==30)
        {
            personaje.setText("luffy")
            foto.setImageResource(R.drawable.luffy)

        }

        else if(cont1 in 31..89)
        {
            personaje.setText("zoro")
            foto.setImageResource(R.drawable.zoro)

        }
        else{
            personaje.setText("sanji")
            foto.setImageResource(R.drawable.sanji)
        }

    }


   @SuppressLint("SuspiciousIndentation")
   fun hacerFoto(view: View){
        intent  = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, captura_imagen )
            
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode== captura_imagen && resultCode == RESULT_OK)
        {
            var extras : Bundle? = data?.extras
            var bitmap:Bitmap = extras?.get("data") as Bitmap
            foto.setImageBitmap(bitmap)
            var fos :FileOutputStream = openFileOutput(crearNombreArchivoJPG(), Context.MODE_PRIVATE)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos)
            fos.close()
        }
    }

    fun crearNombreArchivoJPG(): String {
        var fecha: String = SimpleDateFormat("yyyyMMdd_HHmmss").format( Date())
        return fecha + ".jpg "
    }


    fun guardar(){
        var archivo: String = "puntos25.csv"

        var osw: OutputStreamWriter= OutputStreamWriter(openFileOutput( archivo, Context.MODE_PRIVATE))
       // osw.write(nombre)
        //osw.flush()
        osw.write(cont1)
        osw.flush()
        osw.close()

    }

}