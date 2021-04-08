package com.example.a_ha_main

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("UseCompatLoadingForDrawables", "ClickableViewAccessibility")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var MemoList = ArrayList<Memo_list>()
        MemoList.add(Memo_list("제목1", "내용1", "날짜", null))
        MemoList.add(Memo_list("제목1", "내용1", "날짜", getDrawable(R.drawable.icon_memo_p)!!))
        MemoList.add(Memo_list("제목1", "내용1", "날짜", null))
        MemoList.add(Memo_list("제목1", "내용1", "날짜", null))
        MemoList.add(Memo_list("제목1", "내용1", "날짜", null))

        val adapter = MemoAdapter(MemoList)
        memo_recyclerview.adapter = adapter

        menu_btn.setOnClickListener {
            if (menu_view.visibility == View.GONE) {
                menu_view.visibility = View.VISIBLE
            }
        }
        background_view.setOnTouchListener { _: View, event: MotionEvent ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    if (menu_view.visibility == View.VISIBLE) {
                        menu_view.visibility = View.GONE
                    }
                }
            }
            //리턴값은 return 없이 아래와 같이
            true // or false
        }
        memo_btn.setOnClickListener() {
            val nextIntent = Intent(this, MemoWriteActivity::class.java)
            startActivity(nextIntent)
        }
        chat_Button.setOnClickListener() {
            val nextIntent = Intent(this, AhaActivity::class.java)
            startActivity(nextIntent)
        }
        mypage_Button.setOnClickListener() {
            val nextIntent = Intent(this, MypageActivity::class.java)
            startActivity(nextIntent)
        }
        logout_btn.setOnClickListener() {
            val nextIntent = Intent(this, LoginActivity::class.java)
            startActivity(nextIntent)
        }
        out_btn.setOnClickListener() {
            val nextIntent = Intent(this, LoginActivity::class.java)
            startActivity(nextIntent)
        }
        add_btn.setOnClickListener() {
            val nextIntent = Intent(this, MemoWriteActivity::class.java)
            startActivity(nextIntent)
        }
    }
}