package com.example.youtubeapi.playlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapi.databinding.ItemPlaylistBinding
import com.example.youtubeapi.model.Item
import com.example.youtubeapi.utils.loadImage

class PlaylistAdapter(private val onClick:(String) -> Unit) :
    RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {

    private val data : ArrayList<Item> = arrayListOf()

    fun addData(newData : List<Item>?){

        data.clear()
        if (newData != null) {
            data.addAll(newData)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
       return PlaylistViewHolder(ItemPlaylistBinding.inflate
           (LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.bind(data[position])

    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class PlaylistViewHolder (val binding: ItemPlaylistBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(item: Item) {
            itemView.setOnClickListener {
            onClick(item.id.toString())
        }
          val count =  item.contentDetails?.itemCount
            val title = item.snippet?.channelTitle.toString()
            binding.tvVideoCount.text = "$count video series"
            binding.tvTitle.text = title
            binding.tvDescription.text = item.snippet?.title
            binding.ivVideo.loadImage(item.snippet?.thumbnails?.default?.url.toString()) }
        }
    }