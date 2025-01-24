package com.example.vinylparadise.présentation

import ListGenreAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vinylparadise.R
import com.example.vinylparadise.domaine.adapter.VinylGenreAdapter
import com.example.vinylparadise.domaine.entité.Vinyl

class VinylsParGenreDisplayVue : Fragment() {

    private lateinit var navController: NavController
    private lateinit var vinylAdapter: VinylGenreAdapter
    private lateinit var vinylRecyclerView: RecyclerView
    private lateinit var presentateur: VinylsParGenreDisplayPresentateur
    private lateinit var myTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_vinyls_par_genre, container, false)
        vinylRecyclerView = view.findViewById(R.id.genre_recycler)
        vinylRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        myTextView = view.findViewById(R.id.titreGenre)

        presentateur = VinylsParGenreDisplayPresentateur(this)
        val genre = ListGenreAdapter.GenreHolder.selectedGenre
        val titreGenre = genre?.titre ?: ""
        presentateur.chargerVinylesParGenre(titreGenre)

        return view
    }

    fun afficherVinylesParGenre(vinyles: List<Vinyl>) {
        vinylAdapter = VinylGenreAdapter(vinyles) { vinyl ->
            navController = Navigation.findNavController(requireView())
            navController.navigate(R.id.detailReservationVue)
        }
        vinylRecyclerView.adapter = vinylAdapter
    }

    fun afficherTitreGenre(titre: String) {
        myTextView.text = titre
    }

    fun afficherErreur(message: String) {
    }
}
