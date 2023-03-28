package com.example.wishlist

import java.text.SimpleDateFormat
import java.util.*

class Place(val name: String, val dateAdded: Date = Date()) {// here,s the date for wishlist
    fun formattedDate(): String{
        return SimpleDateFormat("EEE, d, MMM, yyyy", Locale.getDefault()).format(dateAdded)
    }

    override fun toString(): String {// here is the format date to keep up the current date
        return "$name ${formattedDate()}"
    }
}