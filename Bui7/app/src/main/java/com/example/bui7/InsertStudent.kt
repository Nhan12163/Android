package com.example.bui7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.bui7.Model.Student
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class InsertStudent : AppCompatActivity() {
    lateinit var edtname: EditText
    lateinit var edtemail: EditText
    lateinit var edtsdt: EditText
    lateinit var btnadd: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_student)
        edtname = findViewById(R.id.edtname)
        edtemail = findViewById(R.id.edtemail)
        edtsdt = findViewById(R.id.edtsdt)
        btnadd = findViewById(R.id.btnadd)

        btnadd.setOnClickListener { addsinhvien() }
    }

//    private fun addsinhvien() {
//        val name = edtname.text.toString()
//        val email = edtemail.text.toString()
//        val sdt = edtsdt.text.toString()
//        if (name.isNotEmpty() && email.isNotEmpty() && sdt.isNotEmpty()) {
//            CoroutineScope(Dispatchers.IO).launch {
//                val result = RetrofitClient.create().getInsert(name, email, sdt)
//
//            }
//            Toast.makeText(application, "Thêm thành công", Toast.LENGTH_SHORT).show()
//            edtname.setText("")
//            edtemail.setText("")
//            edtsdt.setText("")
//        }else{
//                Toast.makeText(application, "Vui longf điền đầy đủ thông tin", Toast.LENGTH_SHORT).show()
//            }
//        }
private fun addsinhvien() {
    val name = edtname.text.toString()
    val email = edtemail.text.toString()
    val sdt = edtsdt.text.toString()
    if (name.isNotEmpty() && email.isNotEmpty() && sdt.isNotEmpty()) {
        val student = Student( null, name, email, sdt)
        CoroutineScope(Dispatchers.IO).launch {
            val result = RetrofitClient.create().getInsert(student)

        }
        Toast.makeText(application, "Thêm thành công", Toast.LENGTH_SHORT).show()
        edtname.setText("")
        edtemail.setText("")
        edtsdt.setText("")
    }else{
        Toast.makeText(application, "Vui longf điền đầy đủ thông tin", Toast.LENGTH_SHORT).show()
    }
}
    }