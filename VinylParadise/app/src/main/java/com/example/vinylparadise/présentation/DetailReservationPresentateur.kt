package com.example.vinylparadise.présentation

import android.view.View
import com.example.vinylparadise.domaine.entité.Vinyl
import com.example.vinylparadise.sourceDeDonnes.SourceBidon
import com.example.vinylparadise.présentation.Modèle

class DetailReservationPresentateur(private val fragment: DetailReservationVue) {
    val modele = Modèle()
    private val sourceDeDonnées = SourceBidon()
    fun chargerVinylparid(vynil: Vinyl?,view: View) {
        if (vynil == null)
        {
            fragment.afficherErreur("Vinyl non trouvé")
        }else
        {
            fragment.AfficherleVinylEtActiverLeButton(view)
        }
    }

    fun trouverVinylTransfert() : Vinyl?
    {
        return modele.retrouverVinylTransfert()
    }
}