package com.example.a_ha_main

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MemoWriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memowrite)

        var cancle_btn = findViewById(R.id.cancle_btn) as ImageButton // 취소 버튼

        cancle_btn.setOnClickListener() {
            val nextIntent = Intent(this, MainActivity::class.java) // 수정 필요
            startActivity(nextIntent)
        }

    }
}