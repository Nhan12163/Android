package com.example.buoi6

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "course_table")
class Course(courseName: String,  courseDecription:String, courseDuration:String) {
    @PrimaryKey (autoGenerate = true)
    var id:Int =0
    var courseName:String = courseName
    var courseDecription:String = courseDecription
    var courseDuration:String = courseDuration

}



