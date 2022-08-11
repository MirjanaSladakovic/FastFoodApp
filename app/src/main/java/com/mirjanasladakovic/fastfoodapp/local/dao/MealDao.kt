package com.mirjanasladakovic.fastfoodapp.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mirjanasladakovic.fastfoodapp.local.entity.Meal

@Dao
interface MealDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMeal(meal: Meal)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMeals(meals: List<Meal>)

    @Query("SELECT * FROM meal ORDER BY id ASC")
    suspend fun getAllMeals(): List<Meal>

    @Query("DELETE FROM meal")
    suspend fun deleteAll()
}