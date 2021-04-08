package com.example.a_ha_main

import android.system.Os.bind
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.memo_list.view.*

class MemoAdapter(private val items: ArrayList<Memo_list>) : RecyclerView.Adapter<MemoAdapter.ViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MemoAdapter.ViewHolder, position: Int) {
        val item = items[position]
        val listener = View.OnClickListener { it ->
            Toast.makeText(it.context, "Clicked:" + item, Toast.LENGTH_LONG).show()
        }
        holder.apply {
            bind(listener, item)
            itemView.tag = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoAdapter.ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.memo_list, parent, false)
        return MemoAdapter.ViewHolder(inflatedView)
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v
        fun bind(listener: View.OnClickListener, item: Memo_list) {
            view.memo_img.setImageDrawable(item.photo)
            view.title.text = item.title
            view.area.text = item.area
            view.date.text = item.date
        }

    }
}
