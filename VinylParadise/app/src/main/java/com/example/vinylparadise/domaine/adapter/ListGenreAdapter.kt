import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vinylparadise.R
import com.example.vinylparadise.domaine.entité.Genre
import com.example.vinylparadise.domaine.adapter.VinylAdapter

class ListGenreAdapter(
    private val genreList: List<Genre>,
    private val onAfficherToutClick: (Genre) -> Unit
) : RecyclerView.Adapter<ListGenreAdapter.ParentViewHolder>() {
    lateinit var navController: NavController
    inner class ParentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val genreTitle: TextView = itemView.findViewById(R.id.parent_item_title)
        val nestedRecyclerView: RecyclerView = itemView.findViewById(R.id.child_recycler_view)
        val afficherToutButton: TextView = itemView.findViewById(R.id.btnAffichertout)
    }
    object GenreHolder {
        var selectedGenre: Genre? = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_vinyl_par_genre, parent, false)
        return ParentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        val genre = genreList[position]
        holder.genreTitle.text = genre.titre

        holder.nestedRecyclerView.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
        holder.nestedRecyclerView.adapter = VinylAdapter(genre.listVinyl){ vinyl ->
            navController = Navigation.findNavController(holder.itemView)
            navController.navigate(R.id.detailReservationVue)
        }


        holder.afficherToutButton.setOnClickListener {
            onAfficherToutClick(genre)
        }
    }

    override fun getItemCount(): Int = genreList.size
}
