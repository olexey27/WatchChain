package com.example.watchchain.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.watchchain.data.datamodels.Nft
import com.example.watchchain.ui.CollectorFragmentDirections

class CreatorAdapter(
    private val dataset: List<Nft>
): RecyclerView.Adapter<CreatorAdapter.ItemViewHolder>() {

    class ItemViewHolder (val binding: CreatorItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = CreatorItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        val imgUri = item.nftImage.toUri().buildUpon().scheme("https").build()

        holder.binding.nftName.text = item.nftName
        holder.binding.nftPrice.text = item.nftPrice
        holder.binding.nftImage.load(imgUri)
        holder.binding.nftcardView.setOnClickListener {
            holder.itemView.findNavController()
                .navigate(CollectorFragmentDirections.actionCollectorFragmentToNftFragment(item.nftName))
        }
    }
    override fun getItemCount(): Int {
        return dataset.size
    }
}