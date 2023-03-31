package com.example.buoi6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.time.Duration

class UpdateView : AppCompatActivity() {
    lateinit var edtNameCourse:EditText
    lateinit var edtDecriptionCourse:EditText
    lateinit var edtDuration:EditText
    lateinit var btnUpdate:Button
    lateinit var btnDelete:Button
    lateinit var res: CourseRepository
    private lateinit var db:CourseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_view)

        edtNameCourse = findViewById(R.id.updatename)
        edtDecriptionCourse = findViewById(R.id.updatedecriptoon)
        edtDuration = findViewById(R.id.updateduration)
        btnUpdate = findViewById(R.id.btnUpdate)
        btnDelete = findViewById(R.id.btnDelete)
        res = CourseRepository(application)

        if(intent!=null){
            val NameCourse = intent.getStringExtra("name")
            val DecriptionCourse = intent.getStringExtra("decription")
            val DurationCourse = intent.getStringExtra("duration")

            edtNameCourse.setText(NameCourse)
            edtDecriptionCourse.setText(DecriptionCourse)
            edtDuration.setText(DurationCourse)

            btnUpdate.setOnClickListener{
                val course = Course(
                    edtNameCourse!!.text.toString(),
                    edtDecriptionCourse!!.text.toString(),
                    edtDuration!!.text.toString()
                )
                  course.id = res!!.getIdByName(NameCourse.toString())

                res!!.update(course)
                Toast.makeText(application, "Course has been " +
                        "updated.", Toast.LENGTH_SHORT).show()
               val i = Intent(this, MainActivity::class.java)
                startActivity(i)

            }

            btnDelete.setOnClickListener {
                val course = Course (edtNameCourse!!.text.toString(),
                    edtDecriptionCourse!!.text.toString(),
                    edtDuration!!.text.toString())
                course.id = res!!.getIdByName(NameCourse.toString())
                res!!.delete(course)
                Toast.makeText(application, "Course has been " +
                        "deleted.", Toast.LENGTH_SHORT).show()
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
            }
        }


    }
}