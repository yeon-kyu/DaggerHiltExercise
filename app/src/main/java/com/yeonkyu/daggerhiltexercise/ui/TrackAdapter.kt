package com.yeonkyu.daggerhiltexercise.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.yeonkyu.daggerhiltexercise.R
import com.yeonkyu.daggerhiltexercise.data.api.TrackResponse
import com.yeonkyu.daggerhiltexercise.databinding.ItemTrackBinding

class TrackAdapter : RecyclerView.Adapter<TrackAdapter.TrackViewHolder>(){
    private val trackList = ArrayList<TrackResponse>()

    fun setTrackList(list: ArrayList<TrackResponse>){
        trackList.clear()
        trackList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val binding:ItemTrackBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.item_track,parent,false)
        return TrackViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        holder.onBind(trackList[position])
    }

    override fun getItemCount(): Int {
        return trackList.size
    }

    inner class TrackViewHolder(private val binding: ItemTrackBinding): RecyclerView.ViewHolder(binding.root){

        fun onBind(track: TrackResponse){
            binding.trackItem = track

            binding.trackListStarButton.setOnClickListener {
                track.isFavorite = !track.isFavorite
                if(track.isFavorite){
                    binding.trackListStarButton.setImageResource(R.drawable.icon_star_gold_32)
                }
                else{
                    binding.trackListStarButton.setImageResource(R.drawable.icon_star_white_32)
                }
            }

            if(track.isFavorite){
                binding.trackListStarButton.setImageResource(R.drawable.icon_star_gold_32)
            }
            else{
                binding.trackListStarButton.setImageResource(R.drawable.icon_star_white_32)
            }
            binding.executePendingBindings()
        }
    }
}