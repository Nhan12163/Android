package com.example.buoi5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.buoi5.DB.DBHelper

class UpdateCourse : AppCompatActivity() {
    lateinit var courseNameedt:EditText
    lateinit var courseDecriptionedt:EditText
    lateinit var courseDurationedt:EditText
    lateinit var courseTrackedt:EditText
    lateinit var btnUpdateedt:Button
    lateinit var btnDeleteedt:Button
    lateinit var db:DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_course)

        courseNameedt = findViewById(R.id.UDnamecourse)
        courseDecriptionedt = findViewById(R.id.UDdecriptioncourse)
        courseDurationedt = findViewById(R.id.UDdurationcourse)
        courseTrackedt = findViewById(R.id.UDtrackcourse)
        btnUpdateedt = findViewById(R.id.btnupdate)
        btnDeleteedt = findViewById(R.id.btndelete)

        db= DBHelper(this, null)
        if (intent != null) {
            val courseName = intent.getStringExtra("name")
            val courseDecription = intent.getStringExtra("decription")
            val courseDuration = intent.getStringExtra("duration")
            val courseTrack = intent.getStringExtra("track")

            courseNameedt.setText(courseName)
            courseDecriptionedt.setText(courseDecription)
            courseDurationedt.setText(courseDuration)
            courseTrackedt.setText(courseTrack)

            btnUpdateedt.setOnClickListener {
                db!!.updateCourse(courseName,
                courseNameedt.text.toString(),
                courseDecriptionedt.text.toString(),
                courseDurationedt.text.toString(),
                courseTrackedt.text.toString())

                Toast.makeText(application, "Update ...", Toast.LENGTH_SHORT).show()
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
            }

            btnDeleteedt.setOnClickListener{
                db!!.deleteCourse(courseName)

                Toast.makeText(application, "Delete success", Toast.LENGTH_SHORT).show()
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
            }
        }


    }
}