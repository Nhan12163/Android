package com.example.thigk

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.thigk.DB.DBHelper

class AddNew : AppCompatActivity() {
    lateinit var edtname:EditText
    lateinit var edtemail:EditText
    lateinit var edtphone:EditText
    lateinit var btnadd:Button
    lateinit var db:DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new)

        edtname = findViewById(R.id.edtname)
        edtphone = findViewById(R.id.edtphone)
        edtemail = findViewById(R.id.edtemail)
        btnadd = findViewById(R.id.btnadd)

        db= DBHelper(this, null)

        btnadd.setOnClickListener { addct() }

    }
    private fun addct() {
        val Name = edtname.text.toString()
        val Phone = edtphone.text.toString()
        val Email = edtemail.text.toString()

        if (Name.isEmpty() || Phone.isEmpty() || Email.isEmpty()) {
            Toast.makeText(applicationContext, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT)
                .show()
        } else {


            db!!.addContact(Name, Phone, Email)
            Toast.makeText(applicationContext, "Dữ liệu đã được thêm", Toast.LENGTH_SHORT).show()
            edtname.setText("")
            edtphone.setText("")
            edtemail.setText("")
        }
    }
}