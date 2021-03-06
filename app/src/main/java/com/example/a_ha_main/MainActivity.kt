package com.example.a_ha_main

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.PopupMenu
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("UseCompatLoadingForDrawables", "ClickableViewAccessibility")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    var MemoList = arrayListOf<Memo_list>(
            Memo_list("제목1", "내용1", "날짜", "icon_memo_text"),
            Memo_list("제목1", "내용1", "날짜", "icon_memo_p"),
            Memo_list("제목1", "내용1", "날짜", "icon_memo_text"),
            Memo_list("제목1", "내용1", "날짜", "icon_memo_text"),
            Memo_list("제목1", "내용1", "날짜", "icon_memo_text"),
            Memo_list("제목1", "내용1", "날짜", "icon_memo_text"),
            Memo_list("제목1", "내용1", "날짜", "icon_memo_text"),
            Memo_list("제목1", "내용1", "날짜", "icon_memo_text"),
            Memo_list("제목1", "내용1", "날짜", "icon_memo_text"),
            Memo_list("제목1", "내용1", "날짜", "icon_memo_text"),
            Memo_list("제목1", "내용1", "날짜", "icon_memo_text"),
            Memo_list("제목1", "내용1", "날짜", "icon_memo_text"),
            Memo_list("제목1", "내용1", "날짜", "icon_memo_text")
    )
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mAdapter = MemoAdapter(this, MemoList)
        memo_recyclerview.adapter = mAdapter

        val lm = LinearLayoutManager(this)
        memo_recyclerview.layoutManager = lm
        memo_recyclerview.setHasFixedSize(true)

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
        chat_btn.setOnClickListener() {
            val nextIntent = Intent(this, AhaActivity::class.java)
            startActivity(nextIntent)
        }
        list_btn.setOnClickListener() {
            var popup = PopupMenu(this, list_btn)
            menuInflater.inflate(R.menu.option_menu, popup.menu)

            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.modify ->
                        startActivity(Intent(this, MainModifyActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION))

                    R.id.delete ->
                        startActivity(Intent(this, MainDeleteActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION))
                }
                false
            }
            popup.show()
        }
    }
    override fun onBackPressed() {}
}