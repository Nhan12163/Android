package com.example.buoi6

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Course::class), version = 1, exportSchema = false)
abstract class CourseDatabase : RoomDatabase(){
    abstract fun myDao():CourseDao
    companion object{
        @Volatile
        private var INSTANCE: CourseDatabase? = null
        fun getInstance(context: Context): CourseDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    CourseDatabase::class.java, "course_database"
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}


