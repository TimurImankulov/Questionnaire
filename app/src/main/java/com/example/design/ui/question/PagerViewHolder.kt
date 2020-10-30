package com.example.design.ui.question

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.design.R
import kotlinx.android.synthetic.main.item_questions.view.*

class PagerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(
        question: String,
        position: Int,
        size: Int,
        listener: PagerListener
    ) {
        itemView.tvQuestion.text = question
        itemView.tvPageNumber.text =
            itemView.context.resources.getString(R.string.page_number, (position + 1), size)

        itemView.btnYes.setOnClickListener {
            listener.selectAnswer(true, position)
        }
        itemView.btnNo.setOnClickListener {
            listener.selectAnswer(false, position)
        }
    }
}
