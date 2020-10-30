package com.example.design.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class PagerDecorator : RecyclerView.ItemDecoration() { // метод который передает RecyclerView переконвертируемые данные из dp в px

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val horizontalMargin = parent.context.dpToPx(26f)
        outRect.left = horizontalMargin
        outRect.right = horizontalMargin
    }
}
