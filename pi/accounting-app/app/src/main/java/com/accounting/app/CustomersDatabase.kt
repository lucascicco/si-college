package com.accounting.app

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(CustomersEntity::class), version = 1)
abstract class CustomersDatabase : RoomDatabase() {

    abstract fun DAO() : CustomersDao

    companion object {
        private var INSTANCE : CustomersDatabase? = null

        @Synchronized
        fun getInstance(context : Context) : CustomersDatabase {

            if(INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    CustomersDatabase::class.java,
                    "database.db").build()
            }
            return INSTANCE as CustomersDatabase
        }
    }
}
