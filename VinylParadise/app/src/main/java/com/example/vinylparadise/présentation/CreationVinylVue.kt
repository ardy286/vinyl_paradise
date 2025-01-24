package com.example.vinylparadise.présentation

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.vinylparadise.R
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class CreationVinylVue : Fragment() {
    var présentateur = CreationVinylPrésentateur(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = inflater.inflate(R.layout.creation_vinyl_fragment, container, false)

        val titreEditText: TextInputEditText = binding.findViewById(R.id.textInputTitre)
        val artistEditText: TextInputEditText = binding.findViewById(R.id.textInputArtist)
        val priceEditText: TextInputEditText = binding.findViewById(R.id.textInputPrix)
        val descriptionEditText: TextInputEditText = binding.findViewById(R.id.textInputDescription)
        val urlImageEditText: TextInputEditText = binding.findViewById(R.id.textInputImage)
        val nomUtilisateurEditText: TextInputEditText = binding.findViewById(R.id.textInputNom)
        val emailUtlisateurEditText: TextInputEditText = binding.findViewById(R.id.email)

        val genreSpinner: Spinner = binding.findViewById(R.id.spinner_genre)

        val genres =présentateur.obtenirListNomGenres()

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, genres)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        genreSpinner.adapter = adapter

        val saveButton: View = binding.findViewById(R.id.btnSave)
        saveButton.setOnClickListener {
            val title = titreEditText.text.toString().trim()
            val artist = artistEditText.text.toString().trim()
            val prix = priceEditText.text.toString().trim()
            val description = descriptionEditText.text.toString().trim()
            val urlImage = urlImageEditText.text.toString().trim()
            val selectedGenre = genreSpinner.selectedItem.toString()
            val nomUtilisateur = nomUtilisateurEditText.text.toString().trim()
            val emailUtilisateur = emailUtlisateurEditText.text.toString().trim()

            val isValid = présentateur.validerLesChamps(
                title, artist, prix, urlImage, nomUtilisateur, emailUtilisateur,
                titreEditText, artistEditText, priceEditText, urlImageEditText,
                nomUtilisateurEditText, emailUtlisateurEditText
            )

            if (isValid) {
                lifecycleScope.launch {
                    val isValidImage = présentateur.isImageUrlValidWithHttp(urlImage)
                    if (!isValidImage) {
                        urlImageEditText.error = getString(R.string.erreur_invalid_url)
                    } else {
                        // Affichez la boîte de dialogue de confirmation
                        AlertDialog.Builder(requireContext())
                            .setTitle(getString(R.string.title_dialogue_confirmation))
                            .setMessage(getString(R.string.message_dialogue_confirmation))
                            .setPositiveButton(getString(R.string.button_dialogue_positive)) { _, _ ->
                                // L'utilisateur confirme.
                                présentateur.ajoutVinyl(
                                    title, artist, prix, urlImage, selectedGenre,
                                    description, nomUtilisateur, emailUtilisateur
                                )
                                Toast.makeText(requireContext(), getString(R.string.toast_vinyl_ajout), Toast.LENGTH_SHORT).show()
                                findNavController().navigate(R.id.action_creationVinylFragment_to_vinylsDisplayFragment)
                            }
                            .setNegativeButton(getString(R.string.button_dialogue_negative)) { dialog, _ ->
                                // L'utilisateur annule
                                dialog.dismiss()
                            }
                            .show()
                    }
                }
            }
        }
        return binding
    }



}
