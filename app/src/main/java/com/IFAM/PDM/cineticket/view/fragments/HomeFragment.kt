package com.IFAM.PDM.cineticket.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.IFAM.PDM.cineticket.view.adapter.MovieAdapter
import com.IFAM.PDM.cineticket.R
import com.IFAM.PDM.cineticket.model.Movie

class HomeFragment : Fragment(), MovieAdapter.OnMovieItemClickListener {

    private val movieListEmAlta: List<Movie> = listOf(
        Movie("Jogos Vorazes", R.drawable.filme_jogos_vor),
        Movie("Ó Pai, Ó 2", R.drawable.filme_o_pai),
        Movie("As Marvels", R.drawable.filme_ms_marvels),
        Movie("Mussum, O Filmis", R.drawable.filme_mussum),
        Movie("Taylor Swift: The Eras Tour", R.drawable.filme_taylor),
        Movie("Trolls 3", R.drawable.filme_trolls),
        Movie("Five Nights at Freddy's", R.drawable.filme_five_nights),
    )

    private val movieListEmCartaz: List<Movie> = listOf(
        Movie("Napoleão", R.drawable.filme_napoleao),
        Movie("Jogos Vorazes", R.drawable.filme_jogos_vor),
        Movie("As Marvels", R.drawable.filme_ms_marvels),
        Movie("Ó Pai, Ó 2", R.drawable.filme_o_pai),
        Movie("Taylor Swift: The Eras Tour", R.drawable.filme_taylor),
        Movie("NCT NATION: To The World in Cinemas", R.drawable.filme_nct),
        Movie("Trolls 3", R.drawable.filme_trolls),
        Movie("Five Nights at Freddy's", R.drawable.filme_five_nights),
    )

    private val movieListEmBreve: List<Movie> = listOf(
        Movie("As Aventuras de Poliana", R.drawable.filme_poliana),
        Movie("Bala Sem Nome", R.drawable.filme_bala_sem_nome),
        Movie("Digimon Adventure 02: The Beginning", R.drawable.filme_digimon),
        Movie("Eu Sou Maria", R.drawable.filme_maria),
        Movie("Folhas de Outono", R.drawable.filme_folhas_outono),
        Movie("Monster", R.drawable.filme_monster),
        Movie("O jogo da Invocação", R.drawable.filme_o_jogo),
        Movie("Os Segredos do Universo por Aristóteles e Dantes", R.drawable.filme_os_segredos),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val rvEmAlta: RecyclerView = view.findViewById(R.id.view1)
        val layoutManagerEmAlta =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val rvEmCartaz: RecyclerView = view.findViewById(R.id.view2)
        val layoutManagerEmCartaz =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val rvEmBreve: RecyclerView = view.findViewById(R.id.view3)
        val layoutManagerEmBreve =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)


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

        val navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)

        // Navegar para o fragmento de detalhes do filme
        navController.navigate(R.id.action_homeFragment_to_movieDetailFragment, bundle)
    }


}