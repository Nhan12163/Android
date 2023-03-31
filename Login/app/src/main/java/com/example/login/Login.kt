package com.example.login

import android.annotation.SuppressLint
import android.os.Build.VERSION_CODES.M
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.login.DB.DBHelper
import com.example.login.Model.DangNhap
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

class Login : AppCompatActivity() {
    lateinit var edtUser: EditText
    lateinit var edtPass: EditText
    lateinit var btnlogin: Button
    lateinit var db:DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtUser = findViewById(R.id.txtUser)
        edtPass = findViewById(R.id.txtPass)
        btnlogin = findViewById(R.id.btnlogin)
        db= DBHelper(this, null)

        btnlogin.setOnClickListener{dangnhap()}

    }
    private fun dangnhap(){
        val user = edtUser.text.toString()
        val pass = edtPass.text.toString()
        val m = MainActivity()
      //  edtUser.setText("")
     //   edtPass.setText("")
        val dangNhap = db!!.login(user, m.mahoa(pass,m.key))

        if (dangNhap.getName() == null && dangNhap.getPass() == null) {
            Toast.makeText(applicationContext, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show()

        } else {
            Toast.makeText(applicationContext, "Đăng nhập thành công", Toast.LENGTH_SHORT).show()
            edtUser.setText("")
            edtPass.setText("")
        }

    }

}