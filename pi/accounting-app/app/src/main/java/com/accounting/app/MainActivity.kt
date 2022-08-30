package com.accounting.app

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.helper.ItemTouchHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var database : CustomersDatabase

    val adapter = Adapter()


    lateinit var customersList : LiveData<List<CustomersEntity>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupDatabase()
        setupRecyclerView()

        customersList.observe(this, Observer {
            it?.let { lista -> adapter.setData(lista) }
        })

        fab_new_customer.setOnClickListener {
            val newCustomerActivity = Intent(this, NewCustomerActivity::class.java)
            startActivity(newCustomerActivity)
        }
    }

    fun setupDatabase() {
        database = CustomersDatabase.getInstance(this)
        customersList = database.DAO().getAll()
    }

    fun setupRecyclerView() {
        val touchHelper = ItemTouchHelper(TouchHelper(adapter, this))
        touchHelper.attachToRecyclerView(recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = adapter
    }

}
