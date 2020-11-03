package com.example.design.ui.answer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Toast
import com.example.design.R
import com.example.design.ui.question.QuestionsActivity.Companion.POINTS
import com.example.design.utils.AnswerEnum
import com.example.design.utils.ClickSpan
import com.example.design.utils.safeOnClickListener
import kotlinx.android.synthetic.main.activity_answer.*

class AnswerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)
        setupViews()
        setupListener()

    }

    private fun setupViews() {

        val result = AnswerEnum.selectTypeOfEnum(intent.getIntExtra(POINTS, -1))

        tvTitle.text = getString(result.textTitle)
        tvSmallDesc.text = getString(result.smallTitle)
        tvBigDesc.text = getString(result.bigDesc)
        tvBigDesc.setTextSize(TypedValue.COMPLEX_UNIT_SP, result.textSize)

        tvTitle.setTextColor(resources.getColor(result.color))
        tvSmallDesc.setTextColor(resources.getColor(result.color))

        parentLayout.setBackgroundResource(result.parentDrawable)
        divider.setBackgroundResource(result.drawableDivider)

        ClickSpan.clickify(
            tvBigDesc,
            getString(result.bigDescColored),
            getColor(result.color)
        ) {}
    }

    private fun setupListener() {
        btnRefresh.safeOnClickListener {
            finish()
        }
    }
}
