package com.IFAM.PDM.cineticket.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.IFAM.PDM.cineticket.R
import com.IFAM.PDM.cineticket.model.Movie


class MovieFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.movie, container, false)
        val imageView: ImageView = view.findViewById(R.id.image_view)
        val titleTextView: TextView = view.findViewById(R.id.title_text_view)
        val genreTextView: TextView = view.findViewById(R.id.genre_text_view)
        val ratingTextView: TextView = view.findViewById(R.id.rating_text_view)

        val movie: Movie = arguments?.getParcelable("movie")!!

        imageView.setImageResource(movie.imageDrawableId)
        titleTextView.text = movie.title

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val movie = arguments?.getParcelable<Movie>("movie")
        val movieId = arguments?.getString("movieId")
        val movie: Movie? = arguments?.getParcelable("movie")

    }
}