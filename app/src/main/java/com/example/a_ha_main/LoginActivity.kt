package com.example.a_ha_main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var edit_name = findViewById(R.id.edit_name) as EditText // 아이디
        var edit_password = findViewById(R.id.edit_password) as EditText // 비밀번호

        var login_btn = findViewById(R.id.login_btn) as Button // 로그인 버튼
        var join_btn = findViewById(R.id.join_btn) as Button // 회원가입 버튼
        var password_ok_btn = findViewById(R.id.password_ok_btn) as Button // 비밀번호 찾기 버튼

        join_btn.setOnClickListener() {
            val nextIntent = Intent(this, JoinActivity::class.java)
            startActivity(nextIntent)
        }
    }
}