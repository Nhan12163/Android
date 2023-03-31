package com.example.login_mysql

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.login_mysql.Model.DangNhap
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

class MainActivity : AppCompatActivity() {
    lateinit var edtPhone: EditText
    lateinit var edtName: EditText
    lateinit var edtPass: EditText
    lateinit var edtPassRp: EditText
    lateinit var btndk: Button
    lateinit var btnlogin: Button
    val key:String = "Pham Phu Nhan 02"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtPhone = findViewById(R.id.txtPhone)
        edtName = findViewById(R.id.txtName)
        edtPass = findViewById(R.id.txtMk)
        edtPassRp = findViewById(R.id.txtmk)
        btndk = findViewById(R.id.button2)
        btnlogin = findViewById(R.id.btnlogin)

        btndk.setOnClickListener { dk() }

        btnlogin.setOnClickListener {
            var i = Intent(this, Login::class.java)
            startActivity(i)
        }
    }
    private fun dk(){
        val phone = edtPhone.text.toString()
        val user = edtName.text.toString()
        var pass = edtPass.text.toString()
        val passrp = edtPassRp.text.toString()
        if(phone.isEmpty() || user.isEmpty() || pass.isEmpty() || passrp.isEmpty()  ){
            Toast.makeText(applicationContext, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show()
        }else{
            if (pass!=passrp){
                Toast.makeText(applicationContext, "Mật khẩu không giống nhau", Toast.LENGTH_SHORT).show()
            }else{
                val dangnhap = DangNhap (null, user, phone, mahoa(pass,key))
                CoroutineScope(Dispatchers.IO).launch {
                    val result = Retrofitclient.create().Register(dangnhap)

                }
                Toast.makeText(applicationContext, "Đăng kí thành công", Toast.LENGTH_SHORT).show()
                edtName.setText("");
                edtPhone.setText("")
                edtPass.setText("")
                edtPassRp.setText("")
            }
        }
    }
    fun mahoa(kitu: String, key: String): String {
        val skeySpec = SecretKeySpec(key.toByteArray(), "AES")
        val cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING")
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec)
        val byteEncrypted = cipher.doFinal(kitu.toByteArray())
        val encrypted = Base64.getEncoder().encodeToString(byteEncrypted)
        return encrypted
    }

    fun giaima(matma: String, key: String): String {
        val skeySpec = SecretKeySpec(key.toByteArray(), "AES")
        val cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING")
        cipher.init(Cipher.DECRYPT_MODE, skeySpec)
        return String(cipher.doFinal(Base64.getDecoder().decode(matma)))
    }
}