package com.example.vinylparadise.domaine.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.vinylparadise.R
import com.example.vinylparadise.domaine.entité.Vinyl
import com.bumptech.glide.Glide
import com.example.vinylparadise.présentation.Modèle

class VinylAdapter(
    private val vinylList: List<Vinyl>,
    private val onItemClicked: (Vinyl) -> Unit
) : RecyclerView.Adapter<VinylAdapter.VinylViewHolder>() {


    class VinylViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image)
        val nameTextView: TextView = itemView.findViewById(R.id.titre)
        val artistTextView: TextView = itemView.findViewById(R.id.artist)
        val priceTextView: TextView = itemView.findViewById(R.id.prix)
        val cardView: CardView = itemView.findViewById(R.id.phone_Cardview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VinylViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.vinyls_recycler, parent, false)
        return VinylViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: VinylViewHolder, position: Int) {
        val modèle = Modèle()
        val currentVinyl = vinylList[position]
        Glide.with(holder.itemView.context)
            .load(currentVinyl.image_url)
            .into(holder.imageView)

        holder.nameTextView.text = currentVinyl.nom
        holder.artistTextView.text = currentVinyl.artist
        holder.priceTextView.text = "$${currentVinyl.prix}"

        holder.cardView.setOnClickListener {
            modèle.ajouterVinylTransfert(currentVinyl)
            holder.itemView.findNavController().navigate(R.id.detailReservationVue)
        }
    }


    override fun getItemCount() = minOf(vinylList.size, 3)
}

