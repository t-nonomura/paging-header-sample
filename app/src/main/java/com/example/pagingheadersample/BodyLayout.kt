package com.example.pagingheadersample

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.list_item_body.view.*

class BodyLayout constructor(context: Context, attributeSet: AttributeSet?) :
    LinearLayout(context, attributeSet) {

    fun setContent(value: Body) {
        body_text_1.text = value.makerName
        body_text_2.text = value.commodityName
    }
}