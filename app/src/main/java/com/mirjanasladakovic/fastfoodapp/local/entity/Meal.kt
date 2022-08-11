package com.mirjanasladakovic.fastfoodapp.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meal")
class Meal (

    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "Name") val name: String,
    @ColumnInfo(name = "Description") val description: String,
    @ColumnInfo(name = "Group") val group: Int,
    @ColumnInfo(name = "Price") val price: Float
)