package com.skiffold.app.rbusiness.data.local.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "rbusiness_db", indices = [ Index(value = ["time"], unique = true)])
data class RBusinessEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var counter: Int = 0,
    var time: Int = 0,
): Parcelable
