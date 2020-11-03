package com.example.design.ui.question

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuestionsViewModel:ViewModel() {

    var questionResult = 0

    val calculateResult = MutableLiveData<Int>()
    val actionToResult = MutableLiveData<Int>()

    fun calculatePoints(answer: Boolean, position: Int, itemCount: Int) {
        if (position<4 && answer) questionResult += 12
        if (position>=4 && !answer) questionResult += 12
        Log.d("points:", questionResult.toString())
        nextPage(position, itemCount)
    }

    fun calculatePointsFourButton(points: Int, position: Int, itemCount: Int) {
        questionResult += points
        Log.d("points:", questionResult.toString())
        nextPage(position, itemCount)

    }

    fun nextPage(position: Int, itemCount: Int) {
        if (position + 1 == itemCount)
            actionToResult.postValue(questionResult)
    }

}