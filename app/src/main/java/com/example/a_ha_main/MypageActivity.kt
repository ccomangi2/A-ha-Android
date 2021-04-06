package com.example.a_ha_main

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MypageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)

        var menu_btn = findViewById(R.id.menu_btn) as ImageButton // 메뉴
        var menu_view = findViewById(R.id.menu_view) as RelativeLayout // 메뉴 네비게이션
        var background_view = findViewById(R.id.background_view) as View // 메뉴 네비게이션 배경
        var memo_btn = findViewById(R.id.memo_btn) as ImageButton // 메모 작성 버튼
        var chat_Button = findViewById(R.id.chat_Button) as ImageButton // 채팅 버튼
        var mypage_Button = findViewById(R.id.mypage_Button) as ImageButton // 마이페이지 버튼
        var logout_btn = findViewById(R.id.logout_btn) as Button // 로그아웃 버튼
        var out_btn = findViewById(R.id.out_btn) as Button // 회원탈퇴 버튼
        var name = findViewById(R.id.name) as TextView // 이름

        var proflie_setting_btn = findViewById(R.id.proflie_setting_btn) as Button // 프로필 사진 변경 버튼
        var proflie = findViewById(R.id.proflie) as ImageView // 프로필 사진
        var name_textview = findViewById(R.id.name_textview) as TextView // 이름
        var id_textview = findViewById(R.id.id_textview) as TextView // 아이디
        var email_textview = findViewById(R.id.email_textview) as TextView // 이메일
        var main_logout_btn = findViewById(R.id.main_logout_btn) as Button // 로그아웃 버튼
        var main_out_btn = findViewById(R.id.main_out_btn) as Button // 회원탈퇴 버튼

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
    }
}