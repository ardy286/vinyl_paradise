package com.example.vinylparadise.présentation

import ListGenreAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.navigation.fragment.findNavController

import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vinylparadise.R


class VinylsVue : Fragment() {
    private lateinit var listGenreAdapter: ListGenreAdapter
    private lateinit var parentRecyclerView: RecyclerView

    var présentateur = VinylPrésentateur(this)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_vinyls_display, container, false)


    val genres = présentateur.obtenirGenre()


        listGenreAdapter = ListGenreAdapter(genres) { genre ->
            ListGenreAdapter.GenreHolder.selectedGenre = genre
            findNavController().navigate(R.id.action_vinylsDisplayFragment_to_vinylsParGenre)
        }
        parentRecyclerView = view.findViewById(R.id.parent_recycler_view)
        parentRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        parentRecyclerView.adapter = listGenreAdapter



        parentRecyclerView.adapter = listGenreAdapter
        return view
    }






}



