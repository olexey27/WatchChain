package com.example.watchchain.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.watchchain.data.datamodels.Nft
import com.example.watchchain.databinding.NftListBinding
import com.example.watchchain.ui.CollectorFragmentDirections

class CreatorAdapter(
    private val dataset: List<Nft>,
    private val collectionName: String
): RecyclerView.Adapter<CreatorAdapter.ItemViewHolder>() {

    class ItemViewHolder (val binding: NftListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = NftListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        val imgUri = item.nftImage.toUri().buildUpon().scheme("https").build()

        holder.binding.nftName.text = item.nftName
        holder.binding.price.text = item.nftPrice
        holder.binding.nftImage.load(imgUri)
        holder.binding.nftCardView.setOnClickListener {
            holder.itemView.findNavController()
                .navigate(CollectorFragmentDirections.actionCollectorFragmentToNftFragment(item.nftName, collectionName))
        }
    }
    override fun getItemCount(): Int {
        return dataset.size
    }
}