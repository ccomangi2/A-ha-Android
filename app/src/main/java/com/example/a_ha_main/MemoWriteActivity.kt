package com.example.a_ha_main

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MemoWriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memowrite)

        var memo_title_edit = findViewById(R.id.memo_title_edit) as EditText // 메모 제목 버튼
        var memo_edit = findViewById(R.id.memo_edit) as EditText // 메모 내용 버튼

        var cancle_btn = findViewById(R.id.cancle_btn) as ImageButton // 취소 버튼
        var ok_btn = findViewById(R.id.ok_btn) as ImageButton // 작성 버튼
        var add_btn = findViewById(R.id.add_btn) as ImageButton // 이미지 추가 버튼

        cancle_btn.setOnClickListener() {
            val nextIntent = Intent(this, MainActivity::class.java) // 수정 필요
            startActivity(nextIntent)
        }

    }
}