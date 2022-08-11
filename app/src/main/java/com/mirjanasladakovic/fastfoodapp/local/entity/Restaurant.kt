package com.mirjanasladakovic.fastfoodapp.local.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurant")
class Restaurant(

    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "Name") val name: String,
    @ColumnInfo(name = "Description") val description: String,
    @ColumnInfo(name = "Grade") val grade: Float,
    @ColumnInfo(name = "DeliveryInMinutes") val deliveryInMinutes: Int,

    @Embedded(prefix = "meal_")
    @ColumnInfo(name = "Meals") val meals: List<Meal>
)