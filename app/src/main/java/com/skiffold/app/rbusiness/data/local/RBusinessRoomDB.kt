package com.skiffold.app.rbusiness.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.skiffold.app.rbusiness.data.local.dao.RBusinessDao
import com.skiffold.app.rbusiness.data.local.models.RBusinessEntity

@Database(entities = [RBusinessEntity::class], version = 1, exportSchema = false)
abstract class RBusinessRoomDB : RoomDatabase() {
    abstract fun openSkyDao(): RBusinessDao
}