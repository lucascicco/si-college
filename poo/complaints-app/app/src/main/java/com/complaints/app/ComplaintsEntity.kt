package com.complaints.app

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "complaintsTable")
data class ComplaintsEntity(
     @PrimaryKey
     var code : String = "",
     var description : String = "",
     var date : String = "")
