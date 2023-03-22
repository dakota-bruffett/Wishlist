package com.example.wishlist

import androidx.lifecycle.ViewModel

class PlacesViewModel:ViewModel() {
    private val placeNames = mutableListOf<String>("San francisco", "California ")

    fun getPlaces(): List<String> {
        return placeNames //a way to return the list
    }

    fun addNewPlaces(place: String, position: Int? = null): Int {
        for (placeName in placeNames){ if (placeName.uppercase() == place.uppercase()){ return -1
            }
        return if (position== null){
            placeNames.add(place)
            placeNames.lastIndex
        }else{
            placeNames.add(position,place)
            position
        }


        }
        placeNames.add(place) // add a name any name

        return placeNames.lastIndex
    }

}
