package com.example.vinylparadise.présentation

import com.example.vinylparadise.domaine.entité.Genre
import com.example.vinylparadise.domaine.entité.Vinyl
import com.example.vinylparadise.sourceDeDonnes.SourceBidon

class Modèle {
    val source_de_données = SourceBidon()


    fun ajoutVinyl(vinyl: Vinyl){

    source_de_données.ajoutVinyl(vinyl = vinyl)
    }
    fun obtenirListGenreNom(): List<String>{

       return source_de_données.obtenirListNomGenres()
    }
    fun obtenirGenres() : List<Genre>{
        return source_de_données.obtenirGenres()
    }

    fun ajouterVinylTransfert(vinyl:Vinyl){
        source_de_données.ajouterVinylTransfert(vinyl)
    }

     fun retrouverVinylTransfert() : Vinyl? {return source_de_données.retrouverVinylTransfert()}


    fun obetenirVinylFiltrer(query: String): List<Vinyl> {
        return source_de_données.obtenirVinyls().filter { vinyl ->
            vinyl.nom.contains(query, ignoreCase = true) || vinyl.artist.contains(query, ignoreCase = true)
        }
    }
}