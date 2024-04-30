package uz.octo.feature_movies.presentation.view.support_tab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.octo.feature_movies.R

class SupportAdapter(private val supportList: List<SupportItem>) :
    RecyclerView.Adapter<SupportAdapter.SupportViewHolder>() {

    inner class SupportViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val logoTv: ImageView = itemView.findViewById(R.id.parentLogoIv)
        val titleTv: TextView = itemView.findViewById(R.id.parentTitleTv)
        val childRecyclerView: RecyclerView = itemView.findViewById(R.id.langRecyclerView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupportViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.support_item, parent, false)
        return SupportViewHolder(view)
    }

    override fun getItemCount(): Int {
        return supportList.size
    }

    override fun onBindViewHolder(holder: SupportViewHolder, position: Int) {
        val partentItem = supportList[position]
        holder.logoTv.setImageResource(partentItem.logo)
        holder.titleTv.text = partentItem.title

        holder.childRecyclerView.setHasFixedSize(true)
        holder.childRecyclerView.layoutManager = GridLayoutManager(holder.itemView.context, 2)
        val adapter = ChildAdapter(partentItem.mList)
        holder.childRecyclerView.adapter = adapter

    }
}