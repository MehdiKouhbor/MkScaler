package com.example.mkscaler

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView

class MkTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private val mkScaler = MkScaler(context)

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.MkTextView, defStyleAttr, 0)
        val mkTextSize = a.getDimension(R.styleable.MkTextView_mkTextSize, 0f)
        if (mkTextSize > 0) {
            setTextSize(TypedValue.COMPLEX_UNIT_PX, mkScaler.scaleSp(mkTextSize))
        }
        a.recycle()
    }

    override fun setLayoutParams(params: ViewGroup.LayoutParams) {
        if (params.width > 0) {
            params.width = mkScaler.scaleDp(params.width.toFloat()).toInt()
        }
        if (params.height > 0) {
            params.height = mkScaler.scaleDp(params.height.toFloat()).toInt()
        }
        super.setLayoutParams(params)
    }
}
