package com.example.videorich.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.videorich.R
import com.example.videorich.VideojuegoDetailActivity
import com.example.videorich.models.Videojuego

class VideojuegoAdapter(
    private val videojuegos: List<Videojuego>,
    private val onItemClick: (Videojuego) -> Unit
) : RecyclerView.Adapter<VideojuegoAdapter.VideojuegoViewHolder>() {

    inner class VideojuegoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val titulo = view.findViewById<TextView>(R.id.txtTitulo)
        private val genero = view.findViewById<TextView>(R.id.txtGenero)
        private val descripcion = view.findViewById<TextView>(R.id.txtDescripcion)
        private val imagen = view.findViewById<ImageView>(R.id.imgVideojuego)

        fun bind(videojuego: Videojuego) {
            titulo.text = videojuego.titulo
            genero.text = videojuego.genero
            descripcion.text = videojuego.descripcion
            imagen.setImageResource(videojuego.imagen)

            itemView.setOnClickListener { onItemClick(videojuego) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideojuegoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_videojuego, parent, false)
        return VideojuegoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideojuegoViewHolder, position: Int) {
        holder.bind(videojuegos[position])

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, VideojuegoDetailActivity::class.java).apply {
                putExtra("titulo", videojuegos[position].titulo)
                putExtra("genero", videojuegos[position].genero)
                putExtra("descripcion", videojuegos[position].descripcion)
                putExtra("imagen", videojuegos[position].imagen)
            }
            it.context.startActivity(intent)
        }
    }


    override fun getItemCount() = videojuegos.size
}
