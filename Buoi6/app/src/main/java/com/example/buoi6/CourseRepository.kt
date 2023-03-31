package com.example.buoi6

import android.app.Application

class CourseRepository(var application: Application) {
    private lateinit var db:CourseDatabase

    init{
        db= CourseDatabase.getInstance(application)
    }

    fun insert(course: Course?) {
        db.myDao().insert(course)
    }

    fun update(course: Course?) {
        db.myDao().update(course)
    }

    fun getIdByName(NameCourse:String): Int {
        return db.myDao().getIdByName(NameCourse)
    }

    fun getSearchCourses(NameCourse:String): List<Course> {
        return db.myDao().getSearchCourses("%$NameCourse%")
    }

    fun delete(course: Course?) {
        db.myDao().delete(course)
    }

    fun deleteAll() {
        db.myDao().deleteAllCourses()
    }

    fun getAll(): List<Course?>? {
        return db.myDao().getAllCourses
    }


}