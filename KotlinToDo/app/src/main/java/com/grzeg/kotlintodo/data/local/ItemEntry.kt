package com.grzeg.kotlintodo.data.local

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity (tableName = "items")
data class ItemEntry(
        @PrimaryKey (autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
        @ColumnInfo(name = "title") val title: String = "",
        @ColumnInfo(name = "description") val description: String = ""
)