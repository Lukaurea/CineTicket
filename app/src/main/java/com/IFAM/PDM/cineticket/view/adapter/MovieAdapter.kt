package com.ifam.pdm.cineticket.view.adapter;
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ifam.pdm.cineticket.R
import com.ifam.pdm.cineticket.model.Movie

class MovieAdapter(private val movies: kotlin.collections.List<Movie>, private val clickListener: OnMovieItemClickListener) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.movieTitle.text = movie.title
        holder.movieImage.setImageResource(movie.imageDrawableId)

        holder.itemView.setOnClickListener {
            clickListener.onItemClick(movie)
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieImage: ImageView = itemView.findViewById(R.id.movieImage)
        val movieTitle: TextView = itemView.findViewById(R.id.movieTitle)
    }

    interface OnMovieItemClickListener {
        fun onItemClick(movie: Movie)
    }
}
