package com.example.design.ui.question

interface PagerListener {
    fun selectAnswer(answer: Boolean, position: Int)
    fun selectAnswerFourQuestions(points: Int, position: Int)

}