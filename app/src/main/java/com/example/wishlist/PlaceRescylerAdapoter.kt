package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlaceRescylerAdapoter(private val places: List<String>): RecyclerView.Adapter<PlaceRescylerAdapoter.ViewHolder>()



{
    class ViewHolder (private val view: View):RecyclerView.ViewHolder(view){
        fun bind(place: String){
            val placenameTextView: TextView = view.findViewById(R.id.place_name)
            placenameTextView.text = place

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.place_list_item, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place = places[position]
        holder.bind(place)
    }

    override fun getItemCount(): Int {
        return places.size
    }
}