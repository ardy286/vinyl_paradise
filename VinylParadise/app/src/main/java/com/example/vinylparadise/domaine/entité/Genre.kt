package com.example.vinylparadise.domaine.entité

class Genre(
    val titre :String,
    val listVinyl :MutableList<Vinyl> = mutableListOf()
)
