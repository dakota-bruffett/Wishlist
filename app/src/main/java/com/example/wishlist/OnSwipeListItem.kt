package com.example.wishlist

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
interface OnDateChagedListener{
    fun onListItemMoved(from:Int, to: Int)
    fun onListItemDeleted(position:Int)
}

class OnSwipeListItem(val onDateChagedListener: OnDateChagedListener):
    ItemTouchHelper.SimpleCallback(
    ItemTouchHelper.UP or ItemTouchHelper.DOWN,
    ItemTouchHelper.RIGHT
) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        val fromposition = viewHolder.adapterPosition
        val Toposition = viewHolder.adapterPosition
        onDateChagedListener.onListItemMoved(fromposition,Toposition)
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        if (direction == ItemTouchHelper.RIGHT){
            onDateChagedListener.onListItemDeleted(viewHolder.adapterPosition)
        }
    }
}