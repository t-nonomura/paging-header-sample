package com.example.pagingheadersample

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.list_item_header.view.*

class HeaderLayout constructor(context: Context, attributeSet: AttributeSet?) :
    LinearLayout(context, attributeSet) {

    fun setContent(value: Header) {
        header_text_1.text = value.shopName
    }
}