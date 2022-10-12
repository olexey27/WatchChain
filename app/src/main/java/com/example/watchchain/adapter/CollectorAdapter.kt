package com.example.watchchain.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.watchchain.data.datamodels.Nft
import com.example.watchchain.databinding.CollectorItemBinding
import com.example.watchchain.ui.BrowserFragmentDirections

class CollectorAdapter(
    private val context: Context,
) : RecyclerView.Adapter<CollectorAdapter.ItemViewHolder>() {

    private var dataset = emptyList<Nft>()

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<Nft>) {
        dataset = list
        notifyDataSetChanged()
    }

    class ItemViewHolder(val binding: CollectorItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val binding = CollectorItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        val imgUri = item.nftImage.toUri().buildUpon().scheme("http").build()

        holder.binding.nftImage1.load(imgUri)
        holder.binding.nftImage2.load(imgUri)
        holder.binding.nftImage3.load(imgUri)
        holder.binding.collectionName.text = item.collectionName
        holder.binding.idCollectoreView.text = item.collectorName

        val imgUri2 = item.collectorLogo.toUri().buildUpon().scheme("http").build()

        holder.binding.imageLogo.load(imgUri2)

        holder.binding.CollectorCard.setOnClickListener {
            holder.itemView.findNavController()
                .navigate(BrowserFragmentDirections.actionBrowserFragmentToCollectorFragment())
        }

    }



    /*class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
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
        holder.collectorName.text = context.resources.getString(item.collectorName)
        holder.collectorLogo.setImageResource(item.collectorLogo)
        holder.collectorTitlePic.setImageResource(item.collectorTitlePic)

        holder.textView.text = context.resources.getString(item.nameNft)
        holder.priceView.text = context.resources.getString(item.price)
        holder.imageView.setImageResource(item.nftImage)
        holder.cardView.setOnClickListener {
            val navController = holder.view.findNavController()
            navController.navigate(CollectorFragmentDirections.actionCollectorFragmentToNftFragment())
        }
    }*/

    override fun getItemCount(): Int {
        return dataset.size
    }
}