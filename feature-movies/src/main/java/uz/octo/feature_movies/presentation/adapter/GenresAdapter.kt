package uz.octo.feature_movies.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.octo.feature_movies.domain.model.genres.Genre
import uz.octo.feature_movies.databinding.GenresItemBinding
import uz.octo.feature_movies.databinding.BodyRowBinding

class GenresAdapter(
    val genresList: List<Genre>,
) : RecyclerView.Adapter<GenresAdapter.GenresViewHolder>() {

    class GenresViewHolder(val binding: GenresItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GenresViewHolder {
        val binding = GenresItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GenresViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GenresViewHolder, position: Int) {
        holder.binding.nameGenres.text = genresList[position].name
        Log.i("GENRES",genresList[position].name)
    }

    override fun getItemCount(): Int = genresList.size
}