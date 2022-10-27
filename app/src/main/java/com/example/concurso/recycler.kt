package com.example.concurso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class recycler : AppCompatActivity() {


        val nombres = arrayOf("luffy","zoro","sanji")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
    }
}