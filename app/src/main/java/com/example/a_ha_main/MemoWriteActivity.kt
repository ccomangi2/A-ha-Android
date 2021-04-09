package com.example.a_ha_main

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_memowrite.*

class MemoWriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memowrite)

        memo_edit.addTextChangedListener(textWatcher)
        memo_title_edit.addTextChangedListener(textWatcher)

        cancle_btn.setOnClickListener() {
            val nextIntent = Intent(this, MainActivity::class.java) // 수정 필요
            startActivity(nextIntent)
        }
    }
    private val textWatcher = object : TextWatcher {
        @SuppressLint("UseCompatLoadingForDrawables")
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun afterTextChanged(p0: Editable?) {
            //입력이 끝날 때
            if(memo_title_edit.length() == 0 || memo_edit.length() == 0) {
                ok_btn.setImageResource(R.drawable.button_check_off)
            } else {
                ok_btn.setImageResource(R.drawable.button_check)
            }
        }
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            //입력 하기 전에
        }
        @SuppressLint("UseCompatLoadingForDrawables")
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            //타이핑 되는 텍스트에 변화가 있을 때
            if(memo_title_edit.length() == 0 || memo_edit.length() == 0) {
                ok_btn.setImageResource(R.drawable.button_check_off)
            } else {
                ok_btn.setImageResource(R.drawable.button_check)
            }
        }
    }
}
