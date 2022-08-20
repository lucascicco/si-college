package com.complaints.app

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(ComplaintsEntity::class), version = 1)
abstract class ComplaintsDatabase : RoomDatabase(){

    abstract fun DAO() : ComplaintsDao

    companion object {
        private var INSTANCE : ComplaintsDatabase? = null

        @Synchronized
        fun getInstance(context : Context) : ComplaintsDatabase {

            if(INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    ComplaintsDatabase::class.java,
                    "database.db").build()
            }
            return INSTANCE as ComplaintsDatabase
        }
    }
}
