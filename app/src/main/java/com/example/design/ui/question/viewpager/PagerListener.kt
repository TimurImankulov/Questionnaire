package com.example.design.ui.question.viewpager

interface PagerListener {
    fun selectAnswer(answer: Boolean, position: Int)
    fun selectAnswerFourQuestions(points: Int, position: Int)

}