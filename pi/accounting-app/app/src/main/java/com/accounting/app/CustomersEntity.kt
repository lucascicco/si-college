package com.accounting.app

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "customersTable")
data class CustomersEntity(
     @PrimaryKey
     var name : String = "",
     var doc : String = "",
     var description : String = "",
     var joinedAt : String = ""
)
