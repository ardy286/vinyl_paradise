package com.example.vinylparadise.sourceDeDonnes

import com.example.vinylparadise.domaine.entité.Genre
import com.example.vinylparadise.domaine.entité.Vendeur
import com.example.vinylparadise.domaine.entité.Vinyl
import java.util.Date

class SourceBidon : SourceDeDonnées{

    companion object {
        var vinylTransfert : Vinyl? = null

        val vinyls: MutableList<Vinyl> = mutableListOf(
            Vinyl("1", "Hit Me Hard And Soft", "Billie Eilish", mutableListOf("Pop"), Vendeur("1", "John", "Doe", "john@example.com"), Date(), "https://m.media-amazon.com/images/I/51TH1unr6lL._AC_UL480_.jpg", 29.99, "Un album pop mélancolique qui explore les thèmes de la vulnérabilité émotionnelle."),
            Vinyl("2", "Future Nostalgia", "Dua Lipa", mutableListOf("Pop"), Vendeur("4", "Alice", "Smith", "alice@example.com"), Date(), "https://m.media-amazon.com/images/I/81dhBdiI4+L._AC_UL480_.jpg", 27.99, "Un album pop énergique qui mélange des sons rétro et modernes."),
            Vinyl("3", "Thank U, Next", "Ariana Grande", mutableListOf("Pop"), Vendeur("5", "Robert", "Brown", "robert@example.com"), Date(), "https://m.media-amazon.com/images/I/61QPrKmNUtL._AC_UL480_.jpg", 28.99, "Un album personnel et cathartique qui reflète le parcours d'Ariana."),
            Vinyl("4", "1989", "Taylor Swift", mutableListOf("Pop"), Vendeur("6", "Emily", "Davis", "emily@example.com"), Date(), "https://m.media-amazon.com/images/I/71D+2KMj3mL._AC_UL480_.jpg", 26.99, "Un album pop emblématique qui marque la transition de Taylor Swift de la musique country au pop grand public."),
            Vinyl("5", "Oncle Jazz", "Men I Trust", mutableListOf("Indie"), Vendeur("2", "Jane", "Doe", "jane@example.com"), Date(), "https://m.media-amazon.com/images/I/718bjuNoywL._AC_UL480_.jpg", 24.99, "Un album indie rêveur avec des mélodies apaisantes et des paroles introspectives."),
            Vinyl("6", "Currents", "Tame Impala", mutableListOf("Indie", "Psychedelic Rock"), Vendeur("7", "Sarah", "Connor", "sarah@example.com"), Date(), "https://m.media-amazon.com/images/I/91dTLHSQdkL._AC_UL480_.jpg", 32.99, "Un voyage psychédélique à travers la pop électronique et le rock expérimental."),
            Vinyl("7", "IGOR", "Tyler, The Creator", mutableListOf("Indie", "Hip-Hop"), Vendeur("8", "James", "Bond", "james@example.com"), Date(), "https://m.media-amazon.com/images/I/81FL9iS8NiL._AC_UL480_.jpg", 29.99, "Un album qui défie les genres et mélange hip-hop, soul et musique alternative."),
            Vinyl("8", "The Slow Rush", "Tame Impala", mutableListOf("Indie", "Electronic"), Vendeur("9", "Lucas", "Perry", "lucas@example.com"), Date(), "https://m.media-amazon.com/images/I/71ZCkZehO4L._AC_UL480_.jpg", 30.99, "Un album indie électro qui explore les thèmes du temps et du changement."),
            Vinyl("9", "Kind of Blue", "Miles Davis", mutableListOf("Jazz"), Vendeur("10", "Oliver", "Smith", "oliver@example.com"), Date(), "https://m.media-amazon.com/images/I/714qvKD4U+L._AC_UL480_.jpg", 21.99, "Un album de jazz légendaire connu pour son approche modale et ses improvisations fluides."),
            Vinyl("10", "Bewitched", "Laufey", mutableListOf("Jazz"), Vendeur("11", "Natalie", "King", "natalie@example.com"), Date(), "https://m.media-amazon.com/images/I/61LDRPO-YQL._AC_UL480_.jpg", 25.99, "Un mélange délicat d'éléments jazz et classiques avec des voix captivantes."),
            Vinyl("11", "Mingus Ah Um", "Charles Mingus", mutableListOf("Jazz"), Vendeur("12", "James", "Dean", "james@example.com"), Date(), "https://m.media-amazon.com/images/I/81tdxxwX7JL._AC_UL480_.jpg", 27.99, "Un album révolutionnaire qui mêle big band, blues et jazz avant-gardiste."),
            Vinyl("12", "Time Out", "Dave Brubeck Quartet", mutableListOf("Jazz"), Vendeur("13", "Nina", "Cole", "nina@example.com"), Date(), "https://m.media-amazon.com/images/I/81bP0cSs1PL._AC_UL480_.jpg", 23.99, "Un album jazz classique connu pour ses signatures temporelles innovantes et son attrait intemporel."),
            Vinyl("13", "Dark Side of the Moon", "Pink Floyd", mutableListOf("Rock", "Progressive Rock"), Vendeur("3", "Jim", "Beam", "jim@example.com"), Date(), "https://m.media-amazon.com/images/I/510UiCRAu4L._AC_UL480_.jpg", 28.99, "Un album concept qui explore les thèmes de la maladie mentale, de la vie et de la mort."),
            Vinyl("14", "Abbey Road", "The Beatles", mutableListOf("Rock", "Classic Rock"), Vendeur("14", "Jessica", "Lee", "jessica@example.com"), Date(), "https://m.media-amazon.com/images/I/81GH9G5ayjL._AC_UL480_.jpg", 30.99, "Un chef-d'œuvre du rock, qui mélange pop, blues et sons psychédéliques."),
            Vinyl("15", "Led Zeppelin IV", "Led Zeppelin", mutableListOf("Rock"), Vendeur("15", "Michael", "Jordan", "michael@example.com"), Date(), "https://m.media-amazon.com/images/I/A1HXKqAXNcL._AC_UL480_.jpg", 29.99, "Un album emblématique avec des hymnes rock puissants et des arrangements complexes."),
            Vinyl("17", "To Pimp a Butterfly", "Kendrick Lamar", mutableListOf("Hip-Hop"), Vendeur("17", "Will", "Smith", "will@example.com"), Date(), "https://m.media-amazon.com/images/I/81kQ21kX02L._AC_UL480_.jpg", 33.99, "Un album profondément politique qui mêle jazz, funk et spoken word."),
            Vinyl("18", "Illmatic", "Nas", mutableListOf("Hip-Hop"), Vendeur("18", "Chris", "Evans", "chris@example.com"), Date(), "https://m.media-amazon.com/images/I/71ufaET1CHS._AC_UL480_.jpg", 24.99, "Un classique du hip-hop connu pour ses paroles poétiques et l'ambiance brute de New York."),
            Vinyl("19", "The Miseducation of Lauryn Hill", "Lauryn Hill", mutableListOf("Hip-Hop", "R&B"), Vendeur("19", "Emma", "Stone", "emma@example.com"), Date(), "https://m.media-amazon.com/images/I/91+pm4ht4SL._AC_UL480_.jpg", 26.99, "Une fusion de hip-hop, R&B et soul, cet album est à la fois personnel et puissant."),
            Vinyl("20", "DAMN.", "Kendrick Lamar", mutableListOf("Hip-Hop"), Vendeur("20", "Ryan", "Reynolds", "ryan@example.com"), Date(), "https://m.media-amazon.com/images/I/81NaIQgaIzL._AC_UL480_.jpg", 30.99, "Un album introspectif et expérimental qui a remporté le prix Pulitzer.")

        )

        val genres: MutableList<Genre> = mutableListOf(
            Genre("Pop", vinyls.filter { it.genres.contains("Pop") }.toMutableList()),
            Genre("Indie", vinyls.filter { it.genres.contains("Indie") }.toMutableList()),
            Genre("Jazz", vinyls.filter { it.genres.contains("Jazz") }.toMutableList()),
            Genre("Rock", vinyls.filter { it.genres.contains("Rock") }.toMutableList()),
            Genre("Hip-Hop", vinyls.filter { it.genres.contains("Hip-Hop") }.toMutableList())
        )
    }

    override fun obtenirVinyls(): List<Vinyl> {

        return vinyls
    }

    override fun obtenirGenres(): List<Genre> {

        return genres

    }

    fun ajouterVinylTransfert(vinyl:Vinyl){
        vinylTransfert = vinyl
    }

    fun retrouverVinylTransfert() : Vinyl? {return vinylTransfert}

    override fun obtenirListNomGenres(): List<String> {

        val listGenreNom = mutableListOf<String>()

        for (genre in genres) {
            listGenreNom.add(genre.titre)
        }

        return listGenreNom
    }

    override fun ajoutVinyl(vinyl :Vinyl): Boolean {
        return try {
            vinyls.add(vinyl)
            val genre = genres.find { it.titre == vinyl.genres.firstOrNull() }
            genre?.listVinyl?.add(vinyl) ?: genres.add(Genre(vinyl.genres.first(), mutableListOf(vinyl)))
            true
        } catch (e: Exception) {
            false
        }
    }

    override fun trouverVenylParId(id: Int): Vinyl? {
        return vinyls.find { it.id == id.toString() }
    }



}