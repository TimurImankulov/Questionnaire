package com.example.design.ui.question

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.design.R
import kotlinx.android.synthetic.main.item_questions.view.tvPageNumber
import kotlinx.android.synthetic.main.item_questions.view.tvQuestion
import kotlinx.android.synthetic.main.item_questions_four_buttons.view.*

class PagerFourViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(
        question: String,
        position: Int,
        size: Int,
        listener: PagerListener
    ) {
        itemView.tvQuestion.text = question
        itemView.tvPageNumber.text =
            itemView.context.resources.getString(R.string.page_number, (position + 1), size)

        itemView.btnOne.setOnClickListener {
            listener.selectAnswerFourQuestions(0, position)
        }
        itemView.btnTwo.setOnClickListener {
            listener.selectAnswerFourQuestions(4, position)
        }
        itemView.btnThree.setOnClickListener {
            listener.selectAnswerFourQuestions(8, position)
        }
        itemView.btnFour.setOnClickListener {
            listener.selectAnswerFourQuestions(12, position)
        }
    }
}
