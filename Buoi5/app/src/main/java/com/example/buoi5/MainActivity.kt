package com.example.buoi5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.buoi5.DB.DBHelper

class MainActivity : AppCompatActivity() {
    lateinit var course_name:EditText
    lateinit var decription:EditText
    lateinit var duration:EditText
    lateinit var track: EditText
    lateinit var btnadd:Button
    lateinit var btnread:Button
    lateinit var db: DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        course_name = findViewById(R.id.course_name)
        decription = findViewById(R.id.course_decription)
        duration = findViewById(R.id.course_duration)
        track = findViewById(R.id.course_track)
        btnadd = findViewById(R.id.btnAdd)
        btnread = findViewById(R.id.btnRead)
        db= DBHelper(this, null)
        btnadd!!.setOnClickListener{
            add_Course()
        }
        btnread!!.setOnClickListener{
            val i = Intent (this, Display::class.java)
            startActivity(i)
        }
    }
    private fun add_Course(){
        var CourseName = course_name.text.toString()
        val CourseDecription = decription.text.toString()
        val CourseDuration = duration.text.toString()
        val CourseTrack = track.text.toString()
        if(CourseName.isEmpty() || CourseDecription.isEmpty()
            || CourseDuration.isEmpty() || CourseTrack.isEmpty()){
            Toast.makeText(applicationContext,"Vui lòng điền đầy đủ thông tin",Toast.LENGTH_SHORT).show()
        }else{
            db!!.addCourse(CourseName,CourseDecription,
                CourseDuration,CourseTrack)
            Toast.makeText(applicationContext,"Khóa học đã được thêm",Toast.LENGTH_SHORT).show()

            course_name.setText("")
            decription.setText("")
            duration.setText("")
            track.setText("")
        }


    }
}