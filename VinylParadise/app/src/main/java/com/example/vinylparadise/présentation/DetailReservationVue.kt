package com.example.vinylparadise.présentation

import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.vinylparadise.R


class DetailReservationVue : Fragment() {
    private lateinit var navController: NavController
    private lateinit var presenter: DetailReservationPresentateur

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail_reservation_vue, container, false)
        presenter = DetailReservationPresentateur(this)
        val vinyl = presenter.trouverVinylTransfert()
        presenter.chargerVinylparid(vinyl,view)
        return view
    }

    fun AfficherleVinylEtActiverLeButton(view : View)
    {


        // Récupération des informations
        val vinylNom = presenter.trouverVinylTransfert()?.nom
        val vinylPrice = presenter.trouverVinylTransfert()?.prix
        val vinylArtiste = presenter.trouverVinylTransfert()?.artist
        val emailVinylVendeur = presenter.trouverVinylTransfert()?.vendeur?.email
        val vinylDescription = presenter.trouverVinylTransfert()?.description
        val vinylImage = presenter.trouverVinylTransfert()?.image_url

        view.findViewById<TextView>(R.id.produitTitre).text = vinylNom
        view.findViewById<TextView>(R.id.produitPrix).text = "$$vinylPrice"
        view.findViewById<TextView>(R.id.produitDescription).text = vinylDescription
        view.findViewById<TextView>(R.id.produitArtiste).text = vinylArtiste

        val imageView = view.findViewById<ImageView>(R.id.produitImage)
        vinylImage?.let { imageUrl ->
            Glide.with(view.context)
                .load(imageUrl)

                .into(imageView)
        }

        val emailButton = view.findViewById<Button>(R.id.button)
        emailButton?.setOnClickListener {
            val sujet = getString(R.string.sujet_email, vinylNom)
            val corps = getString(R.string.corps_email, vinylNom, vinylArtiste, vinylPrice.toString())


            val uri = Uri.parse(
                "mailto:$emailVinylVendeur?subject=${Uri.encode(sujet)}&body=${Uri.encode(corps)}"
            )

            // fenetre de confirmation
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle(getString(R.string.titre_dialogue))
            builder.setMessage(getString(R.string.message_dialogue))
            builder.setPositiveButton(getString(R.string.bouton_ok)) { _, _ ->
                // si l'utilisateur confirme
                val emailIntent = Intent(Intent.ACTION_SENDTO, uri)
                try {
                    startActivity(Intent.createChooser(emailIntent, getString(R.string.choisir_email)))
                } catch (e: ActivityNotFoundException) {
                    Toast.makeText(requireContext(), getString(R.string.aucune_appli_email), Toast.LENGTH_SHORT).show()
                }
                navController = Navigation.findNavController(view)
                navController.navigate(R.id.vinylsDisplayFragment)
            }
            builder.setNegativeButton(getString(R.string.bouton_annuler)) { dialog, _ ->
                dialog.dismiss()
            }


            builder.create().show()
        }


    }

    fun afficherErreur(message: String) {
    }
}