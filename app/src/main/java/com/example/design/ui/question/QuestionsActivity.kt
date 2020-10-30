package com.example.design.ui.question

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.design.R
import com.example.design.ui.answer.AnswerActivity
import com.example.design.utils.PagerDecorator
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity(), PagerListener {

    private val adapter by lazy {
        PagerAdapter(this)
    }

    private var questionResult = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        setupViewPager()
    }

//    override fun onBackPressed() {
//        if (pager.currentItem > 0) {
//            pager.currentItem -= 1
//        } else {
//            super.onBackPressed()
//        }
//    }

    private fun setupViewPager() {
        pager.adapter = adapter
        pager.isUserInputEnabled = false
        pager.offscreenPageLimit = 6
        pager.addItemDecoration(PagerDecorator())   // добавляем в ViewPager отступы

        adapter.update(generateData())
    }

    private fun generateData(): ArrayList<String> {
        val list = arrayListOf<String>()

        list.add(getString(R.string.question_one))
        list.add(getString(R.string.question_two))
        list.add(getString(R.string.question_three))
        list.add(getString(R.string.question_four))
        list.add(getString(R.string.question_five))
        list.add(getString(R.string.question_six))

        return list
    }

    override fun selectAnswer(answer: Boolean, position: Int) {  // клик для 2 кнопок
        if (position<4 && answer) questionResult += 12
        if (position>=4 && !answer) questionResult += 12

        nextPage(position)
    }

    override fun selectAnswerFourQuestions(points: Int, position: Int) { // клик для 4 кнопок
        questionResult += points
        nextPage(position)
    }

    private fun nextPage(position: Int) {
        pager.currentItem += 1

        if (position + 1 == adapter.itemCount) {
            val intent = Intent(this, AnswerActivity::class.java)
            intent.putExtra(POINTS, questionResult)
            startActivity(intent)
            finish()
        }
    }

    companion object {
        const val POINTS = "POINTS"
    }
}
