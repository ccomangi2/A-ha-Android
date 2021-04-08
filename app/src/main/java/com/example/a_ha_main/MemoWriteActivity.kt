package com.example.a_ha_main

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_memowrite.*

class MemoWriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memowrite)


        cancle_btn.setOnClickListener() {
            val nextIntent = Intent(this, MainActivity::class.java) // 수정 필요
            startActivity(nextIntent)
        }

    }
}