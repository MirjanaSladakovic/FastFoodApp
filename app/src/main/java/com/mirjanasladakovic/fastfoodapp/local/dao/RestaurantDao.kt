package com.mirjanasladakovic.fastfoodapp.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mirjanasladakovic.fastfoodapp.local.entity.Restaurant

@Dao
interface RestaurantDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(restaurant: Restaurant)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(restaurants: List<Restaurant>)

    @Query("SELECT * FROM restaurant ORDER BY id ASC")
    suspend fun getAllRestaurants(): List<Restaurant>

    @Query("DELETE FROM restaurant")
    suspend fun deleteAll()
}