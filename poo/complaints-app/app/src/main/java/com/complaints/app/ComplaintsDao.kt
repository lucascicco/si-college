package com.complaints.app

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface ComplaintsDao {

    @Query("SELECT * from complaintsTable")
    fun getAllComplaints() : List<ComplaintsEntity>

    @Query("SELECT * from complaintsTable")
    fun getAll() : LiveData<List<ComplaintsEntity>>

    @Insert
    fun insertComplaint(complaints : ComplaintsEntity)

    @Delete
    fun deleteComplaint(complaint : ComplaintsEntity)

}
