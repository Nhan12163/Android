package com.example.buoi6

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao

@Dao
interface CourseDao {
    @Insert
    fun insert(mode: Course?)

    @Update
    fun update(mode: Course?)

    @Query("SELECT id FROM course_table WHERE courseName = :courseName")
    fun getIdByName(courseName: String): Int

    @Delete
    fun delete(model: Course?)
    @Query("DELETE FROM course_table")
    fun deleteAllCourses()

    @get:Query("SELECT * FROM course_table ORDER BY courseName ASC")
        val getAllCourses: List<Course>

    @Query("SELECT * FROM course_table WHERE courseName like :Namecourse ORDER BY courseName ASC")
    fun getSearchCourses(Namecourse:String): List<Course>

}
