package com.example.design.ui.question.viewpager

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.design.R
import com.example.design.utils.safeOnClickListener
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

        itemView.btnOne.safeOnClickListener {
            listener.selectAnswerFourQuestions(0, position)
        }
        itemView.btnTwo.safeOnClickListener {
            listener.selectAnswerFourQuestions(4, position)
        }
        itemView.btnThree.safeOnClickListener {
            listener.selectAnswerFourQuestions(8, position)
        }
        itemView.btnFour.safeOnClickListener {
            listener.selectAnswerFourQuestions(12, position)
        }
    }
}
