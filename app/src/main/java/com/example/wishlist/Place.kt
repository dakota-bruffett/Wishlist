package com.example.wishlist

import java.text.SimpleDateFormat
import java.util.*

class Place(val name: String, val dateAdded: Date = Date()) {
    fun formattedDate(): String{
        return SimpleDateFormat("EEE, d, MMM, yyyy", Locale.getDefault()).format(dateAdded)
    }

    override fun toString(): String {
        return "$name ${formattedDate()}"
    }
}