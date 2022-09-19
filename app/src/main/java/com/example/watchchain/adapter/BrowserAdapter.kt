package com.example.watchchain.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.watchchain.R
import com.example.watchchain.data.datamodels.Browser
import com.example.watchchain.ui.BrowserFragmentDirections

class BrowserAdapter(
    private val dataset: List<Browser>
) : RecyclerView.Adapter<BrowserAdapter.ItemViewHolder>() {

    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val nftImage: ImageView = view.findViewById(R.id.nft_image)
        val nftImage2: ImageView = view.findViewById(R.id.nft_image2)
        val nftImage3: ImageView = view.findViewById(R.id.nft_view)
        val collectionName: TextView = view.findViewById(R.id.collection_name)
        val idCollector: TextView = view.findViewById(R.id.id_collectore_view)
        val imageLogo: ImageView = view.findViewById(R.id.image_logo)
        val collectorLayout: ConstraintLayout = view.findViewById(R.id.CollectorLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.collector_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.nftImage.setImageResource(item.nftImage)
        holder.nftImage2.setImageResource(item.nftImage2)
        holder.nftImage3.setImageResource(item.nftImage3)
        holder.collectionName.text = item.collectionName.uppercase()
        holder.idCollector.text = item.idCollector.uppercase()
        holder.imageLogo.setImageResource(item.imageLogo)

        holder.collectorLayout.setOnClickListener {
            holder.view.findNavController()
                .navigate(BrowserFragmentDirections.actionBrowserFragmentToCreatorProfileFragment())
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}