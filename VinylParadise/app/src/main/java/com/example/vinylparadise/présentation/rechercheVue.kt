package com.example.vinylparadise.présentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vinylparadise.R
import com.example.vinylparadise.domaine.adapter.VinylAdapter

class rechercheVue : Fragment() {

    private val présentateur = recherchePresentateur()

    companion object {
        fun newInstance(query: String): rechercheVue {
            val fragment = rechercheVue()
            val args = Bundle()
            args.putString("query", query)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_results, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.resultsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val query = arguments?.getString("query") ?: ""
        val filteredVinyls = présentateur.obtenirVinylFiltrer(query)

        recyclerView.adapter = VinylAdapter(filteredVinyls) { vinyl ->
            println("Vinyl sélectionner: ${vinyl.nom}")
        }

        return view
    }
}
