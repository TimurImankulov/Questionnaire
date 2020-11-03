package com.example.design.utils

import com.example.design.R

enum class AnswerEnum(                      //класс для заполнения верстки ресурсами
    val parentDrawable: Int,   //фон
    val drawableDivider: Int,  //полоса
    val textTitle: Int,        //название
    val smallTitle: Int,       //небольшое описание
    val color: Int,            // цвет текста и полосы
    val bigDesc: Int,          //полное описание
    val bigDescColored: Int,    //слова которым нужно поменять цвет
    val textSize: Float
) {
    DARK_GREEN(
        R.drawable.bg_dark_green,
        R.drawable.bg_view_dark_green,
        R.string.title_dark_green,
        R.string.small_desc_dark_green,
        R.color.dark_green,
        R.string.big_desc_dark_green,
        R.string.big_desc_dark_green_colored,
        17f
    ),
    GREEN(
        R.drawable.bg_green,
        R.drawable.bg_view_green,
        R.string.title_green,
        R.string.small_desc_green,
        R.color.green,
        R.string.big_desc_green,
        R.string.big_desc_green_colored,
        17f
    ),
    YELLOW(
        R.drawable.bg_yellow,
        R.drawable.bg_view_yellow,
        R.string.title_yellow,
        R.string.small_desc_yellow,
        R.color.yellow,
        R.string.big_desc_yellow,
        R.string.big_desc_yellow_colored,
        17f
    ),
    ORANGE(
        R.drawable.bg_orange,
        R.drawable.bg_view_orange,
        R.string.title_orange,
        R.string.small_desc_orange,
        R.color.orange,
        R.string.big_desc_orange,
        R.string.big_desc_orange_colored,
        15f
    ),
    RED(
        R.drawable.bg_red,
        R.drawable.bg_view_red,
        R.string.title_red,
        R.string.small_desc_red,
        R.color.red,
        R.string.big_desc_red,
        R.string.big_desc_red_colored,
        17f
    );

    companion object {
        fun selectTypeOfEnum(points: Int): AnswerEnum {    // в этот методе в зависимоти от баллов используем ресурсы
            return when {
                points <= 12 -> DARK_GREEN
                points in  13..24-> GREEN
                points in 25..36 -> YELLOW
                points in 37..48 -> ORANGE
                else -> RED
            }
        }
    }
}
