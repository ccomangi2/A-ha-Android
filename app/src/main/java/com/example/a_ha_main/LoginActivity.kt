package com.example.a_ha_main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_join.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        join_btn.setOnClickListener() {
            val nextIntent = Intent(this, JoinActivity::class.java)
            startActivity(nextIntent)
        }
    }
}