package com.example.wishlist

import androidx.lifecycle.ViewModel

class PlacesViewModel:ViewModel() {
    private val places = mutableListOf<Place>(Place("San francisco California"))

    fun getPlaces(): List<Place> {
        return places //a way to return the list
    }

    fun addNewPlaces(place: Place, position: Int? = null): Int {
        for (placeName in places){ if (placeName.name.uppercase() == place.name.uppercase()){ return -1
            }
        return if (position== null){
            places.add(place)
            places.lastIndex
        }else{
            places.add(position,place)
            position
        }


        }
        places.add(place) // add a name any name

        return places.lastIndex
    }

}
