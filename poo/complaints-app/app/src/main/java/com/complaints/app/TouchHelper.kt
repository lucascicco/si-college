package com.complaints.app

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import kotlin.concurrent.thread

class TouchHelper(val adapter : Adapter, val context : Context) : ItemTouchHelper.Callback() {
    lateinit var database : ComplaintsDatabase

    override fun getMovementFlags(recyclerView: RecyclerView, viewHOlder: RecyclerView.ViewHolder): Int {
        val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
        val swipeFlags = ItemTouchHelper.START or ItemTouchHelper.END
        return ItemTouchHelper.Callback.makeMovementFlags(dragFlags, swipeFlags)
    }

    override fun onMove(p0: RecyclerView, p1: RecyclerView.ViewHolder, p2: RecyclerView.ViewHolder): Boolean {
       return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, position: Int) {
        database = ComplaintsDatabase.getInstance(context)
        thread {
            database.DAO().deleteComplaint(adapter.getData(viewHolder.adapterPosition))
        }
    }
}
