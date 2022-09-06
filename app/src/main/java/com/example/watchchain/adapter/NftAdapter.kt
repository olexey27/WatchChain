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
import com.example.watchchain.data.datamodels.Nfts
import com.example.watchchain.ui.BrowserFragment

class NftAdapter(
    private val dataset: List<Nfts>
) : RecyclerView.Adapter<NftAdapter.ItemViewHolder>() {

    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val collection_name: TextView = view.findViewById(R.id.collection_name)
        val collector: TextView = view.findViewById(R.id.collector)
        val nft_image: ImageView = view.findViewById(R.id.nft_image)
        val nft_image2: ImageView = view.findViewById(R.id.nft_image2)
        val nft_image3: ImageView = view.findViewById(R.id.nft_image3)
        val logo: ImageView = view.findViewById(R.id.logo)
        val nft_layout: ConstraintLayout = view.findViewById(R.id.nft_layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.nft_list, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.collection_name.text = item.name.uppercase()
        holder.collector.text = item.name.uppercase()
        holder.nft_image.setImageResource(item.imageRecource)
        holder.nft_image2.setImageResource(item.imageRecource)
        holder.nft_image3.setImageResource(item.imageRecource)
        holder.logo.setImageResource(item.imageRecource)
        holder.nft_layout.setBackgroundResource(item.imageRecource)

        holder.nft_layout.setOnClickListener {
            holder.view.findNavController()
                .navigate(BrowserFragmentDirection.act)
        }
    }
    }
}