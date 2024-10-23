package com.example.videorich


import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class VideojuegoDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videojuego_detail)

        val titulo = findViewById<TextView>(R.id.txtTituloDetail)
        val genero = findViewById<TextView>(R.id.txtGeneroDetail)
        val descripcion = findViewById<TextView>(R.id.txtDescripcionDetail)
        val imagen = findViewById<ImageView>(R.id.imgVideojuegoDetail)

        intent?.let {
            titulo.text = it.getStringExtra("titulo")
            genero.text = it.getStringExtra("genero")
            descripcion.text = it.getStringExtra("descripcion")
            imagen.setImageResource(it.getIntExtra("imagen", 0))
        }
    }
}
