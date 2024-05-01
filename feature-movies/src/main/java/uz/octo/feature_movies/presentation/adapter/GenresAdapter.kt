package uz.octo.feature_movies.presentation.adapter

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import uz.octo.feature_movies.R
import uz.octo.feature_movies.domain.model.genre.DomainGenreItem
import uz.octo.feature_movies.databinding.GenresItemBinding
import uz.octo.feature_movies.domain.model.category.DominCategoryItem

class GenresAdapter(
    val genresList: List<DomainGenreItem>,
) : RecyclerView.Adapter<GenresAdapter.GenresViewHolder>() {

    var onItemClick: ((DomainGenreItem) -> Unit)? = null

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
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(genresList[position])
            if(it.id != genresList[position].id){
                holder.binding.nameGenres.setTextColor(Color.DKGRAY)
                holder.binding.cardViewGender.setCardBackgroundColor(Color.CYAN)
            }else{
                holder.binding.nameGenres.setTextColor(Color.GREEN)
                holder.binding.cardViewGender.setCardBackgroundColor(Color.WHITE)
            }

        }
    }

    override fun getItemCount(): Int = genresList.size
}