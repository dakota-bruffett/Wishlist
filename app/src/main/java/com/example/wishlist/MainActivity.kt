package com.example.wishlist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(),onListItemClickedListener {
    private lateinit var addPlaceEditText:EditText
    private lateinit var addnewPlaceButton: Button
    private lateinit var PlacelistRecylerView:RecyclerView

    private lateinit var placeRescylerAdapoter: PlaceRescylerAdapoter
    private val placesViewModel: PlacesViewModel by lazy {
        ViewModelProvider(this).get(PlacesViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addPlaceEditText = findViewById(R.id.new_place_text)
        addnewPlaceButton = findViewById(R.id.Add_button)
        PlacelistRecylerView = findViewById(R.id.Recyler_list)

        val  places = placesViewModel.getPlaces()
        placeRescylerAdapoter = PlaceRescylerAdapoter(places, this)
        PlacelistRecylerView.layoutManager = LinearLayoutManager(this)
        PlacelistRecylerView.adapter = placeRescylerAdapoter
        addnewPlaceButton.setOnClickListener {
            addnewPlace()
        }
    }
// heres a new place adding part
    private fun addnewPlace() {
        val name = addPlaceEditText.text.toString().trim()
        if (name.isEmpty()){
            Toast.makeText(this, "Please enter a place here", Toast.LENGTH_SHORT).show()
        } else {
            val newPlace = Place(name)
            val postionAdded = placesViewModel.addNewPlaces(newPlace)
            if (postionAdded == -1) {
                Toast.makeText(this, "you already put this here try again", Toast.LENGTH_SHORT)
                    .show()
            }else{
            placeRescylerAdapoter.notifyItemInserted(postionAdded)
                clearForm()
                hideKeyboard()
        }
    }
}

    private fun hideKeyboard() {
        this.currentFocus?.let{view ->
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(view.windowToken,0)
        }
    }

    private fun clearForm() {
        addPlaceEditText.text.clear()
    }

    override fun onListItemClicked(place: Place) {
        Toast.makeText(this, "$place globe icon is picked", Toast.LENGTH_SHORT).show()
    }
}
