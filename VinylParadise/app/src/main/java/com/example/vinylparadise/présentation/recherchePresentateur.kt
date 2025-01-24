package com.example.vinylparadise.présentation

import com.example.vinylparadise.sourceDeDonnes.SourceBidon
import com.example.vinylparadise.domaine.entité.Vinyl

class recherchePresentateur {

    val Modèle = Modèle()
    private val sourceBidon = SourceBidon()

    fun obtenirVinylFiltrer(query: String): List<Vinyl> {
        return Modèle.obetenirVinylFiltrer(query)
    }
}
