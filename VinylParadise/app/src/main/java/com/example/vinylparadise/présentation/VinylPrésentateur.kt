package com.example.vinylparadise.présentation

import com.example.vinylparadise.domaine.entité.Genre
import com.example.vinylparadise.sourceDeDonnes.SourceBidon

class VinylPrésentateur( val vue : VinylsVue ) {

val modele = Modèle()

    fun obtenirGenre() : List<Genre>{
      return modele.obtenirGenres()
  }
}