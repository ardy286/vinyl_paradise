package com.example.vinylparadise.présentation

class VinylsParGenreDisplayPresentateur (private val fragment: VinylsParGenreDisplayVue) {

    private val modèle = Modèle()

    fun chargerVinylesParGenre(titre: String) {
        val genres = modèle.obtenirGenres()
        val genre = genres.find { it.titre == titre }

        if (genre != null) {
            fragment.afficherTitreGenre(titre)
            fragment.afficherVinylesParGenre(genre.listVinyl)
        } else {
            fragment.afficherErreur("Genre non trouvé")
        }
    }
}