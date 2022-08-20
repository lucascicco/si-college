package com.complaints.app

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.helper.ItemTouchHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var database : ComplaintsDatabase

    val adapter = Adapter()


    lateinit var complaintsList : LiveData<List<ComplaintsEntity>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupDatabase()
        setupRecyclerView()

        complaintsList.observe(this, Observer {
            it?.let { lista -> adapter.setData(lista) }
        })

        fab_new_complaint.setOnClickListener {
            val newComplaintActivity = Intent(this, NewComplaintActivity::class.java)
            startActivity(newComplaintActivity)
        }
    }

    fun setupDatabase() {
        database = ComplaintsDatabase.getInstance(this)
        complaintsList = database.DAO().getAll()
    }

    fun setupRecyclerView() {
        val touchHelper = ItemTouchHelper(TouchHelper(adapter, this))
        touchHelper.attachToRecyclerView(recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = adapter
    }

}
