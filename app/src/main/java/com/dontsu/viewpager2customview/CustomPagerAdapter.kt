package com.dontsu.viewpager2customview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_item.view.*

class CustomPagerAdapter(private val textList: List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return textList.size
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.view_item, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CustomViewHolder -> {
                val text = textList[position]
                holder.setText(text)
            }
        }
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setText(text: String) {
            itemView.textView.text = text
        }
    }

}
