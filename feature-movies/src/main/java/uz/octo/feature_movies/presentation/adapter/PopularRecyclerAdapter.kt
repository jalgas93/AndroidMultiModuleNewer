import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import uz.octo.core_network.Constants
import uz.octo.feature_movies.domain.model.Popular.DomainPopularItem
import uz.octo.feature_movies.databinding.BodyRowBinding
import uz.octo.feature_movies.domain.model.category.DominCategoryItem

class PopularRecyclerAdapter(
    val moviesList: List<DominCategoryItem>, private val context: Context?,
) :
    RecyclerView.Adapter<PopularRecyclerAdapter.PopularViewHolder>() {

    var onItemClick: ((DominCategoryItem) -> Unit)? = null

    class PopularViewHolder(val binding: BodyRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): PopularViewHolder {
        val binding = BodyRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularViewHolder(binding)

    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(FitCenter(), RoundedCorners(16))
        if (context != null) {
            Glide.with(context)
                .load("${Constants.URL_IMAGE_ORIGINAL}${moviesList[position].backdrop_path}")
                .apply(requestOptions).skipMemoryCache(true).into(holder.binding.imageMain)
        }
        holder.binding.textView2.text = moviesList[position].title
        holder.binding.textView3.text = moviesList[position].overview
        holder.binding.textView4.text = moviesList[position].popularity.toString()

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(moviesList[position])
        }

    }


    override fun getItemCount(): Int = moviesList.size

}
