package com.example.vinylparadise.présentation

import android.content.Context
import android.util.Log
import android.util.Patterns
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.example.vinylparadise.R
import com.example.vinylparadise.domaine.entité.Vendeur
import com.example.vinylparadise.domaine.entité.Vinyl
import com.example.vinylparadise.domaine.service.VinylService

import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

import java.util.Date

class CreationVinylPrésentateur(val  vue : CreationVinylVue) {
    val modèle = Modèle()
    val vinylService = VinylService()

    fun obtenirListNomGenres() : List<String>{
        return modèle.obtenirListGenreNom()
    }
    fun validerLesChamps(  title :String,
                           artist :String,
                           prix :String,
                           urlImage :String,
                           nomUtilisateur :String,
                           emailUtilisateur :String,
                           titreEditText: TextInputEditText ,
                           artistEditText: TextInputEditText,
                            priceEditText: TextInputEditText,
                           urlImageEditText: TextInputEditText ,
                            nomUtilisateurEditText: TextInputEditText ,
                            emailUtlisateurEditText: TextInputEditText ):Boolean{
        var isValid = true
        val context = titreEditText.context // Récupérer le contexte

        if (title.isEmpty()) {
            titreEditText.error = context.getString(R.string.erreur_titre_requis)
            isValid = false
        }

        if (artist.isEmpty()) {
            artistEditText.error = context.getString(R.string.erreur_artiste_requis)
            isValid = false
        }

        if (prix.isEmpty() || prix.toDoubleOrNull() == null) {
            priceEditText.error = context.getString(R.string.erreur_prix_requis)
            isValid = false
        }

        if (urlImage.isEmpty()) {
            urlImageEditText.error = context.getString(R.string.erreur_url_image_requise)
            isValid = false
        }

        if (nomUtilisateur.isEmpty()) {
            nomUtilisateurEditText.error = context.getString(R.string.erreur_nom_utilisateur_requis)
            isValid = false
        }

        if (emailUtilisateur.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(emailUtilisateur).matches()) {
            emailUtlisateurEditText.error = context.getString(R.string.erreur_email_requis)
            isValid = false
        }
        return isValid
    }
    fun ajoutVinyl(title :String,
                   artist :String,
                   prix :String,
                   urlImage :String,
                   selectedGenre: String,
                   description :String,
                   nomUtilisateur :String,
                   emailUtilisateur :String,
    ){
        val vendeur = Vendeur(null, nomUtilisateur, null, emailUtilisateur)

        val nouveauVinyl = Vinyl(
            id = null,
            nom = title,
            artist = artist,
            genres = mutableListOf(selectedGenre),
            vendeur = vendeur,
            dateDeSortie = Date(),
            image_url = urlImage,
            prix = prix.toDouble(),
            description = description
        )
        modèle.ajoutVinyl(nouveauVinyl)


    }


    suspend fun isImageUrlValidWithHttp(url: String): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val connection = URL(url).openConnection() as HttpURLConnection
                connection.apply {
                    connectTimeout = 10000  // Increased timeout to handle slow responses
                    readTimeout = 10000
                    requestMethod = "GET"
                    setRequestProperty(
                        "User-Agent",
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36"
                    )
                    connect()
                }

                val responseCode = connection.responseCode
                val contentType = connection.contentType
                connection.disconnect()

                responseCode == HttpURLConnection.HTTP_OK && contentType?.startsWith("image/") == true
            } catch (e: Exception) {
                false
            }
        }
    }

}
