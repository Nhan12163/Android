package com.example.bui7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.bui7.Model.Student
import com.example.bui7.R.id.updatename
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateView : AppCompatActivity() {
    lateinit var updatename: EditText
    lateinit var updateemail: EditText
    lateinit var updatesdt: EditText
    lateinit var btnupdate: Button
    lateinit var btndelete: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_view)

        updatename = findViewById(R.id.updatename)
        updateemail = findViewById(R.id.updateemail)
        updatesdt = findViewById(R.id.updatesdt)
        btnupdate = findViewById(R.id.btnupdate)
        btndelete = findViewById(R.id.btndelete)

        if(intent!=null){

            val id = intent.getIntExtra("id",0)
            val name = intent.getStringExtra("name")
            val email = intent.getStringExtra("email")
            val sdt = intent.getStringExtra("sdt")

            updatename.setText(name)
            updateemail.setText(email)
            updatesdt.setText(sdt)

            btnupdate.setOnClickListener {
                if (updatename.text.isNotEmpty() && updateemail.text.isNotEmpty() && updatesdt.text.isNotEmpty()) {
                    val student = Student( id, updatename.text.toString(), updateemail.text.toString(), updatesdt.text.toString())
                    CoroutineScope(Dispatchers.IO).launch {
                        val result = RetrofitClient.create().getUpdate(student)
                    }
                    Toast.makeText(application, "Chỉnh sửa thành công", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(application, "Vui longf điền đầy đủ thông tin", Toast.LENGTH_SHORT).show()
                }
            }
            btndelete.setOnClickListener {
                    val student = Student( id, null, null, null)
                    CoroutineScope(Dispatchers.IO).launch {
                        val result = RetrofitClient.create().getDelete(student)
                    }
                    Toast.makeText(application, "Xóa thành công", Toast.LENGTH_SHORT).show()
                    updatename.setText("")
                    updateemail.setText("")
                    updatesdt.setText("")
            }
        }
    }
}