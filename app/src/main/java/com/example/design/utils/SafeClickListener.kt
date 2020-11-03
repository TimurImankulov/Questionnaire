package com.example.design.utils

import android.os.SystemClock
import android.view.View

class SafeClickListener(   // класс для предотвращения множествинных кликов
    private var defaultInterval: Int = 1000,
    private val onSafeCLick: (View) -> Unit // замыкание
) : View.OnClickListener {
    private var lastTimeClicked: Long = 0
    override fun onClick(v: View) {
        if (SystemClock.elapsedRealtime() - lastTimeClicked < defaultInterval) {
            return
        }
        lastTimeClicked = SystemClock.elapsedRealtime()
        onSafeCLick(v)
    }
}

fun View.safeOnClickListener(onSafeClick: (View) -> Unit) {  // extention для view
    val safeClickListener = SafeClickListener {
        onSafeClick(it)
    }
    setOnClickListener(safeClickListener)
}
