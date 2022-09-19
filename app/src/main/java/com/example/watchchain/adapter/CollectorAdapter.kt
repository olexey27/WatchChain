package com.example.watchchain.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.watchchain.R
import com.example.watchchain.data.datamodels.Nft
import com.example.watchchain.ui.CollectorFragmentDirections

class CollectorAdapter(
    private val context: Context,
    private val dataset: List<Nft>
) : RecyclerView.Adapter<CollectorAdapter.ItemViewHolder>() {

    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val collectorName: TextView = view.findViewById(R.id.collector_name)
        val collectorLogo: ImageView = view.findViewById(R.id.profil_picture)
        val collectorTitlePic: ImageView = view.findViewById(R.id.title_background)

        val textView: TextView = view.findViewById(R.id.id_collectore_view)
        val priceView: TextView = view.findViewById(R.id.price_view)
        val imageView: ImageView = view.findViewById(R.id.nft_view)
        val cardView: CardView = view.findViewById(R.id.nft_cardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.nft_list, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.collectorName.text = context.resources.getString(item.collectoreName)
        holder.collectorLogo.setImageResource(item.collectoreLogo)
        holder.collectorTitlePic.setImageResource(item.collectoreTitlePic)

        holder.textView.text = context.resources.getString(item.nameNft)
        holder.priceView.text = context.resources.getString(item.price)
        holder.imageView.setImageResource(item.nftImage)
        holder.cardView.setOnClickListener {
            val navController = holder.view.findNavController()
            navController.navigate(CollectorFragmentDirections.actionCollectorFragmentToNftFragment())
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}