package com.example.a_ha_main

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MemoModifyAdapter(val context: Context, val memoList: ArrayList<Memo_list>) : RecyclerView.Adapter<MemoModifyAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.memo_modify_list, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return memoList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(memoList[position], context)
    }

    fun swapItems(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                memoList[i + 1] = memoList[i]
                memoList[i] = memoList[i + 1]
            }
        } else {
            for (i in fromPosition..toPosition + 1) {
                memoList[i - 1] = memoList[i]
                memoList[i] = memoList[i + 1]
            }
        }

        notifyItemMoved(fromPosition, toPosition)
    }

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val memoPhoto = itemView?.findViewById<ImageView>(R.id.memo_img)
        val memoTitle = itemView?.findViewById<TextView>(R.id.title)
        val memoArea = itemView?.findViewById<TextView>(R.id.area)
        val memoDate = itemView?.findViewById<TextView>(R.id.date)

        fun bind (memo: Memo_list, context: Context) {
            /* memoPhoto setImageResource에 들어갈 이미지의 id를 파일명(String)으로 찾고,
          이미지가 없는 경우 안드로이드 기본 아이콘을 표시한다.*/
            if (memo.photo != "") {
                val resourceId = context.resources.getIdentifier(memo.photo, "drawable", context.packageName)
                memoPhoto?.setImageResource(resourceId)
            } else {
                memoPhoto?.setImageResource(R.mipmap.ic_launcher)
            }
            memoTitle?.text = memo.title
            memoArea?.text = memo.area
            memoDate?.text = memo.date

            itemView.setOnClickListener {
                Intent(context, MemoActivity::class.java).apply {
                    //putExtra("data", item)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { context.startActivity(this) }
            }
        }
    }
}
