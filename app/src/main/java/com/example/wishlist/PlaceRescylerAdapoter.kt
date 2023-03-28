package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

interface onListItemClickedListener {
    fun onListItemClicked(place: Place)
    
}
class PlaceRescylerAdapoter(private val places: List<Place>,
                           private val onListItemClickedListener: onListItemClickedListener):
    RecyclerView.Adapter<PlaceRescylerAdapoter.ViewHolder>()



{
    class ViewHolder (private val view: View):RecyclerView.ViewHolder(view){
        fun bind(place: Place){
            val placenameTextView: TextView = view.findViewById(R.id.place_name)
            placenameTextView.text = place.name
            val dateCreatedOnTextView: TextView = view.findViewById(R.id.Date_added_text)
            val createdOnTextView = view.context.getString(R.string.Createdon, place.formattedDate())
            dateCreatedOnTextView.text = createdOnTextView

            val mapIcon: ImageView = view.findViewById(R.id.map_icon)
            mapIcon.setOnClickListener {

            }

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