package com.example.vinylparadise

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ajoutImage: ImageView = findViewById(R.id.imgAjoutVinyl)
        val searchView = findViewById<SearchView>(R.id.searchView)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    afficherResultatsRecherche(it)
                }
                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {
                query?.let {
                    afficherResultatsRecherche(it)
                }
                return false
            }
        })

        ajoutImage.setOnClickListener {

            findNavController(R.id.fragmentContainerView2).navigate(R.id.creationVinylFragment)
        }
        val logoImage: ImageView = findViewById(R.id.home)
        logoImage.setOnClickListener {
            findNavController(R.id.fragmentContainerView2).navigate(R.id.vinylsDisplayFragment)
        }


    }

    private fun afficherResultatsRecherche(query: String) {
        val bundle = Bundle().apply {
            putString("query", query)
        }
        findNavController(R.id.fragmentContainerView2).navigate(R.id.resultatFragment, bundle)
    }



}