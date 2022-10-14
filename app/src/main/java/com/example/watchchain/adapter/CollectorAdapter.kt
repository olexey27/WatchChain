package com.example.watchchain.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.watchchain.data.datamodels.Collector
import com.example.watchchain.databinding.CollectorItemBinding
import com.example.watchchain.ui.BrowserFragmentDirections

class CollectorAdapter(
    private val dataset: List<Collector>
) : RecyclerView.Adapter<CollectorAdapter.ItemViewHolder>() {


    class ItemViewHolder(val binding: CollectorItemBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =
            CollectorItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        val imgUri = item.collectorLogo.toUri().buildUpon().scheme("https").build()
        val imgUri1 = item.collection[0].nftImage.toUri().buildUpon().scheme("https").build()
        val imgUri2 = item.collection[1].nftImage.toUri().buildUpon().scheme("https").build()
        val imgUri3 = item.collection[2].nftImage.toUri().buildUpon().scheme("https").build()


        holder.binding.collectionName.text = item.collectionName
        holder.binding.idCollectoreView.text = item.collectorName
        holder.binding.imageLogo.load(imgUri)
        holder.binding.nftImage1.load(imgUri1)
        holder.binding.nftImage2.load(imgUri2)
        holder.binding.nftImage3.load(imgUri3)
        holder.binding.CollectorCard.setOnClickListener {
            holder.itemView.findNavController()
                .navigate(BrowserFragmentDirections.actionBrowserFragmentToCollectorFragment(item.collectorName))
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}