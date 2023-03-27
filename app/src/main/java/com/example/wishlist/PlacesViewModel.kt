package com.example.wishlist

import android.util.Log
import androidx.lifecycle.ViewModel
const val TAG= "Places Tag"
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
    fun MovePlace(From:Int, to:Int){
        val place = places.removeAt(From)
        places.add(to, place)
        Log.d(TAG, places.toString())
    }
    fun DeletePlace(position: Int):Place{
       return places.removeAt(position)


    }

}
