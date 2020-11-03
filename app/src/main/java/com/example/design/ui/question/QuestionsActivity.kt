package com.example.design.ui.question

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.design.R
import com.example.design.ui.answer.AnswerActivity
import com.example.design.ui.question.viewpager.PagerAdapter
import com.example.design.ui.question.viewpager.PagerListener
import com.example.design.utils.PagerDecorator
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity(), PagerListener {

    private val viewModel: QuestionsViewModel by viewModels()

    private val adapter by lazy {
        PagerAdapter(this)
    }

    private var questionResult = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        setupViewPager()
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.calculateResult.observe(this, Observer {
            questionResult = it
        })
        viewModel.actionToResult.observe(this, Observer {
            val intent = Intent(this, AnswerActivity::class.java)
            intent.putExtra(POINTS, it)
            startActivity(intent)
            finish()
        })
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
        viewModel.calculatePoints(answer, position, adapter.itemCount)
         nextPage()
    }

    override fun selectAnswerFourQuestions(points: Int, position: Int) { // клик для 4 кнопок
        viewModel.calculatePointsFourButton(points, position, adapter.itemCount)
        nextPage()
    }

    private fun nextPage() {
        pager.currentItem += 1
    }

    companion object {
        const val POINTS = "POINTS"
    }
}
