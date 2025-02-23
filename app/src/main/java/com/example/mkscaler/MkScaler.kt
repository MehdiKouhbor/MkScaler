package com.example.mkscaler

import android.content.Context

class MkScaler(private val context: Context) {
    private val scaleFactor: Float

    init {
        val displayMetrics = context.resources.displayMetrics
        val widthDp = displayMetrics.widthPixels / displayMetrics.density
        scaleFactor = when {
            widthDp >= 800f -> 0.5f
            widthDp >= 720f -> 0.555f
            widthDp >= 600f -> 0.666f
            widthDp >= 360f -> 0.833f
            else -> 1f
        }
    }

    fun scaleDp(dp: Float): Float = dp * scaleFactor
    fun scaleSp(sp: Float): Float = sp * scaleFactor
}
