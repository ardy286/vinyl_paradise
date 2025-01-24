package com.example.vinylparadise.domaine.entité

import java.util.Date

class Vinyl  (val id :String?,
              val nom :String,
              val  artist:String,
              val genres:MutableList<String> = mutableListOf(),
              val vendeur:Vendeur,
              val dateDeSortie: Date?,
              val image_url :String? = "",
              val prix : Double,
              val description: String?
)

