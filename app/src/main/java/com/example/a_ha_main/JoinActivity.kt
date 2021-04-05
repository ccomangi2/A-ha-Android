package com.example.a_ha_main

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class JoinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        var edit_name = findViewById(R.id.edit_name) as EditText // 이름
        var edit_email = findViewById(R.id.edit_email) as EditText // 이메일
        var edit_id = findViewById(R.id.edit_id) as EditText // 아이디
        var edit_password = findViewById(R.id.edit_password) as EditText // 비밀번호
        var edit_password_ok = findViewById(R.id.edit_password_ok) as EditText // 비밀번호 확인

        var join_btn = findViewById(R.id.join_btn) as Button // 회원가입 버튼
    }
}