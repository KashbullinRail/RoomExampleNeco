package com.example.roomexampleneco

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class MainDataBase: RoomDatabase() {

    companion object {
        fun getDataBase(context: Context):MainDataBase {
            return Room.databaseBuilder(
                context.applicationContext,
                MainDataBase::class.java,
                "room.db"
            ).build()
        }
    }

}