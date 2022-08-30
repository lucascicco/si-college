package com.accounting.app

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface CustomersDao {

    @Query("SELECT * from customersTable")
    fun getAllCustomers() : List<CustomersEntity>

    @Query("SELECT * from customersTable")
    fun getAll() : LiveData<List<CustomersEntity>>

    @Insert
    fun insertCustomer(customer: CustomersEntity)

    @Delete
    fun deleteCustomer(customer: CustomersEntity)

}
