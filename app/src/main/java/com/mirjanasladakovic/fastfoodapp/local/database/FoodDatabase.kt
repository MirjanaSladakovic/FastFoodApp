package com.mirjanasladakovic.fastfoodapp.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mirjanasladakovic.fastfoodapp.local.dao.MealDao
import com.mirjanasladakovic.fastfoodapp.local.dao.RestaurantDao
import com.mirjanasladakovic.fastfoodapp.local.entity.Meal
import com.mirjanasladakovic.fastfoodapp.local.entity.Restaurant

@Database(
    entities = [
        Restaurant::class,
        Meal::class
    ],
    //TODO: Create a constant variable for database version
    version = 1,
    exportSchema = false
)
abstract class FoodDatabase: RoomDatabase() {

    abstract fun getRestaurantDao(): RestaurantDao
    abstract fun getMealDao(): MealDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: FoodDatabase? = null

        fun getDatabase(context: Context): FoodDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FoodDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}