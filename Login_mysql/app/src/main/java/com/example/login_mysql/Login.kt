package com.example.login_mysql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.login_mysql.Model.DangNhap
import com.example.login_mysql.Retrofitclient.gson
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response


class Login : AppCompatActivity() {
    lateinit var edtUser: EditText
    lateinit var edtPass: EditText
    lateinit var btnlogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtUser = findViewById(R.id.txtUser)
        edtPass = findViewById(R.id.txtPass)
        btnlogin = findViewById(R.id.btnlogin)

        btnlogin.setOnClickListener{dangnhap()}
    }
    private fun dangnhap(){
        val user = edtUser.text.toString()
        var pass = edtPass.text.toString()
        val m = MainActivity()
        val dangnhap = DangNhap( null, user, null, m.mahoa(pass, m.key))
        val DangNhapApi = Retrofitclient.create()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                withContext(Dispatchers.Main) {
                val result = DangNhapApi.Login(dangnhap)
                if (result.user == null || result.pass == null) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(applicationContext, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show()
                    }
                } else {
                        Toast.makeText(applicationContext, "Đăng nhập thành công", Toast.LENGTH_SHORT).show()
                        edtUser.setText("")
                        edtPass.setText("")
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(applicationContext, "Đăng nhập thất bại"+e, Toast.LENGTH_SHORT).show()
                    edtUser.setText(e.toString())
                }
                e.printStackTrace()
            }
        }
        }
}