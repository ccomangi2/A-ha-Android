package com.example.a_ha_main

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.*
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.add_btn
import kotlinx.android.synthetic.main.activity_main.background_view
import kotlinx.android.synthetic.main.activity_main.chat_Button
import kotlinx.android.synthetic.main.activity_main.logout_btn
import kotlinx.android.synthetic.main.activity_main.memo_btn
import kotlinx.android.synthetic.main.activity_main.memo_recyclerview
import kotlinx.android.synthetic.main.activity_main.menu_btn
import kotlinx.android.synthetic.main.activity_main.menu_view
import kotlinx.android.synthetic.main.activity_main.mypage_Button
import kotlinx.android.synthetic.main.activity_main.out_btn
import kotlinx.android.synthetic.main.activity_main_delete.*
import kotlinx.android.synthetic.main.alert_popup.*
import java.nio.file.Files.delete

class MainDeleteActivity : AppCompatActivity() {
    @SuppressLint("UseCompatLoadingForDrawables", "ClickableViewAccessibility")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)

    var MemoList = arrayListOf<Memo_list>(
            Memo_list("제목1", "내용1", "날짜", "icon_memo_text"),
            Memo_list("제목1", "내용1", "날짜", "icon_memo_p"),
            Memo_list("제목1", "내용1", "날짜", "icon_memo_text"),
            Memo_list("제목1", "내용1", "날짜", "icon_memo_text"),
            Memo_list("제목1", "내용1", "날짜", "icon_memo_text")
    )

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_delete)

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
        delete_btn.setOnClickListener() {
            showdeletePopup()
        }
    }
    private fun showdeletePopup() {
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.alert_popup, null)
        val tv: TextView = view.findViewById(R.id.tv)
        tv.text = "선택한 메모를 삭제하시겠습니까?"

        val alertDialog = AlertDialog.Builder(this, R.style.MyDialogTheme)
                .setTitle("메모 삭제")
                .create()
        val cencle: ImageButton = view.findViewById(R.id.cencle)
        cencle.setOnClickListener() {
            alertDialog.dismiss()
        }
        val ok: ImageButton = view.findViewById(R.id.ok)
        ok.setOnClickListener() {
            alertDialog.dismiss()
        }
        alertDialog.setView(view)
        alertDialog.show()
    }
    override fun onBackPressed() {}
}