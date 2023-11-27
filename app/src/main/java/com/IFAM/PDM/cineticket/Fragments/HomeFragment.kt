package com.IFAM.PDM.cineticket.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.IFAM.PDM.cineticket.Adapter.MovieAdapter
import com.IFAM.PDM.cineticket.R
import com.IFAM.PDM.cineticket.model.Movie
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment(), MovieAdapter.OnMovieItemClickListener {

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

    private val movieListEmBreve: List<Movie> = listOf(
        Movie("As Aventuras de Poliana", R.drawable.poliana),
        Movie("Bala Sem Nome", R.drawable.bala_sem_nome),
        Movie("Digimon Adventure 02: The Beginning", R.drawable.digimon),
        Movie("Eu Sou Maria", R.drawable.maria),
        Movie("Folhas de Outono", R.drawable.folhas_outono),
        Movie("Monster", R.drawable.monster),
        Movie("O jogo da Invocação", R.drawable.o_jogo),
        Movie("Os Segredos do Universo por Aristóteles e Dantes", R.drawable.os_segredos),
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

        val rvEmBreve: RecyclerView = view.findViewById(R.id.view3)
        val layoutManagerEmBreve = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)


        rvEmAlta.layoutManager = layoutManagerEmAlta
        rvEmCartaz.layoutManager = layoutManagerEmCartaz
        rvEmBreve.layoutManager = layoutManagerEmBreve

        val movieAdapterEmAlta = MovieAdapter(movieListEmAlta, this)
        rvEmAlta.adapter = movieAdapterEmAlta

        val movieAdapterEmCartaz = MovieAdapter(movieListEmCartaz, this)
        rvEmCartaz.adapter = movieAdapterEmCartaz

        val movieAdapterEmBreve = MovieAdapter(movieListEmBreve, this)
        rvEmBreve.adapter = movieAdapterEmBreve

        return view
    }

    override fun onItemClick(movie: Movie) {
        val bundle = Bundle()
        bundle.putParcelable("movie", movie)

        val movieDetailFragment = MovieFragment()
        movieDetailFragment.arguments = bundle

        // Navegar para o fragmento de detalhes do filme
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, movieDetailFragment)
            .addToBackStack(null)
            .commit()
    }

}