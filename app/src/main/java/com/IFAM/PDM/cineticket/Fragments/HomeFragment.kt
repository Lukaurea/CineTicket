package com.IFAM.PDM.cineticket.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.IFAM.PDM.cineticket.Adapter.MovieAdapter
import com.IFAM.PDM.cineticket.R
import com.IFAM.PDM.cineticket.model.Movie

class HomeFragment : Fragment() {

    private val movieListEmAlta: List<Movie> = listOf(
        Movie("Jogos Vorazes", R.drawable.jogos_vor),
        Movie("Ó Pai, Ó 2", R.drawable.o_pai),
        Movie("As Marvels", R.drawable.ms_marvels),
        Movie("Mussum, O Filmis", R.drawable.mussum),
        Movie("Taylor Swift: The Eras Tour", R.drawable.taylor),
        Movie("Trolls 3", R.drawable.trolls),
        Movie("Five Nights at Freddy's", R.drawable.five_nights),
    )

    private val movieListEmCartaz: List<Movie> = listOf(
        Movie("Napoleão", R.drawable.napoleao),
        Movie("Jogos Vorazes", R.drawable.jogos_vor),
        Movie("As Marvels", R.drawable.ms_marvels),
        Movie("Ó Pai, Ó 2", R.drawable.o_pai),
        Movie("Taylor Swift: The Eras Tour", R.drawable.taylor),
        Movie("NCT NATION: To The World in Cinemas", R.drawable.nct),
        Movie("Trolls 3", R.drawable.trolls),
        Movie("Five Nights at Freddy's", R.drawable.five_nights),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val rvEmAlta: RecyclerView = view.findViewById(R.id.view1)
        val layoutManagerEmAlta = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val rvEmCartaz: RecyclerView = view.findViewById(R.id.view2)
        val layoutManagerEmCartaz = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)


        rvEmAlta.layoutManager = layoutManagerEmAlta
        rvEmCartaz.layoutManager = layoutManagerEmCartaz

        val movieAdapterEmAlta = MovieAdapter(movieListEmAlta)
        rvEmAlta.adapter = movieAdapterEmAlta

        val movieAdapterEmCartaz = MovieAdapter(movieListEmCartaz)
        rvEmCartaz.adapter = movieAdapterEmCartaz

        return view
    }

}