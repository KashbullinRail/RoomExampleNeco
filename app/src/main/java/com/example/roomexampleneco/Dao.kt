package com.example.roomexampleneco

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface Dao {
    @Insert
    fun insertItem (itemEntity: ItemEntity)
    @Query("SELECT * FROM itemsRoomDb")
    fun getAllItem(): Flow<List<ItemEntity>>


}