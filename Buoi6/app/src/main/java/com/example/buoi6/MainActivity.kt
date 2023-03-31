package com.example.buoi6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var edtCourseName: EditText? = null
    private var edtCourseDescription:EditText? = null
    private var edtCourseDuration:EditText? = null
    private var btnAddCourse: Button? = null
    private var btnReadCourses:Button? = null
    private lateinit var res: CourseRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtCourseName = findViewById(R.id.edtName);
        edtCourseDescription =
            findViewById(R.id.edtDescription);
        edtCourseDuration = findViewById(R.id.edtDuration);
        btnAddCourse = findViewById(R.id.btnAddCourse);
        btnReadCourses = findViewById(R.id.btnReadCourses);
        res = CourseRepository(application)

        btnAddCourse!!.setOnClickListener {
            addCourse()
        }
        btnReadCourses!!.setOnClickListener{
            val i = Intent(this@MainActivity,
                View::class.java)
            startActivity(i)
        }
    }
    fun addCourse() {
        val course = Course(
            edtCourseName!!.text.toString(),
            edtCourseDescription!!.text.toString(),
            edtCourseDuration!!.text.toString()
        )
        res!!.insert(course)
        Toast.makeText(this@MainActivity, "Course has been " +
                "added.", Toast.LENGTH_SHORT).show()
                edtCourseName!!.setText("")
                edtCourseDescription!!.setText("")
                edtCourseDuration!!.setText("")
    }
}