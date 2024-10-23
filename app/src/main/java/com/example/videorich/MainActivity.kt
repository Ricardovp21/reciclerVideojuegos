package com.example.videorich

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.videorich.adapters.VideojuegoAdapter
import com.example.videorich.models.Videojuego

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializa el RecyclerView
        val recyclerVideojuegos = findViewById<RecyclerView>(R.id.recyclerVideojuegos)

        // Lista de videojuegos
        val videojuegos = listOf(
            Videojuego("The Witcher 3", "RPG", "Aventura épica con Geralt de Rivia.", R.drawable.witcher),
            Videojuego("Cyberpunk 2077", "Acción", "Futuro distópico y mundo abierto.", R.drawable.cyberpunk),
            Videojuego("Minecraft", "Sandbox", "Construcción y aventuras sin límite.", R.drawable.minecraft)
        )

        // Configura el RecyclerView
        recyclerVideojuegos.layoutManager = LinearLayoutManager(this)
        recyclerVideojuegos.adapter = VideojuegoAdapter(videojuegos) { videojuego ->
            // Acción al hacer clic en el videojuego
        }
    }
}
