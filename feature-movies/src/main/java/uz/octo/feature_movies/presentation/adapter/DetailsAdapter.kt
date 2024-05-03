package uz.octo.feature_movies.presentation.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import uz.octo.feature_movies.databinding.CardDetailsBinding
import uz.octo.feature_movies.domain.model.details.DomainDetails

class DetailsAdapter(
    val moviesList: DomainDetails,
    private val context: Context?,
) : RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder>() {
    var onItemClick: ((DomainDetails) -> Unit)? = null

    class DetailsViewHolder(val binding: CardDetailsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): DetailsViewHolder {
        val binding = CardDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailsViewHolder(binding)

    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(FitCenter(), RoundedCorners(16))
   /*     if (context != null) {
            Glide.with(context)
                .load("${Constants.URL_IMAGE_ORIGINAL}${moviesList.backdrop_path}")
                .apply(requestOptions).skipMemoryCache(true).into(holder.binding.)
        }*/



        holder.itemView.setOnClickListener {
            onItemClick?.invoke(moviesList)
        }

    }


    override fun getItemCount(): Int = 0
}