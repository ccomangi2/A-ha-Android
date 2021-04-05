package com.example.a_ha_main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var join_btn = findViewById(R.id.join_btn) as Button // 회원가입 버튼

        join_btn.setOnClickListener() {
            val nextIntent = Intent(this, JoinActivity::class.java)
            startActivity(nextIntent)
        }
    }
}