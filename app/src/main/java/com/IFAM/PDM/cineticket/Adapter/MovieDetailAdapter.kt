package com.IFAM.PDM.cineticket.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.IFAM.PDM.cineticket.R
import com.IFAM.PDM.cineticket.model.MovieDetail

class MovieDetailAdapter(private val movieDetail: MovieDetail) : RecyclerView.Adapter<MovieDetailAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Use movieDetail para preencher as visualizações
        holder.titleTextView.text = movieDetail.title
        holder.genreTextView.text = movieDetail.genre
        holder.ratingTextView.text = movieDetail.rating
        // Restante do código...
    }

    override fun getItemCount(): Int {
        // Retorne o número de itens, geralmente 1 para detalhes do filme
        return 1
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Declare as visualizações específicas do layout aqui
        val titleTextView: TextView = itemView.findViewById(R.id.title_text_view)
        val genreTextView: TextView = itemView.findViewById(R.id.genre_text_view)
        val ratingTextView: TextView = itemView.findViewById(R.id.rating_text_view)
        // Adicione outras visualizações conforme necessário
    }
}