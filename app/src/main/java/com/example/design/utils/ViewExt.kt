package com.example.design.utils

import android.content.Context
import android.util.TypedValue

fun Context.dpToPx(dimens: Float?): Int {  // это расширение для Context, этот метод узнает параметры экрана телефона и переделывает dp в пиксели
    val metrics = applicationContext.resources.displayMetrics
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dimens ?: 0f, metrics)
        .toInt()
}
