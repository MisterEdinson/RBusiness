package com.skiffold.app.rbusiness.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.skiffold.app.rbusiness.data.local.models.RBusinessEntity

@Dao
interface RBusinessDao {
    @Query("SELECT * FROM rbusiness_db")
    suspend fun getAll(): List<RBusinessEntity>
}