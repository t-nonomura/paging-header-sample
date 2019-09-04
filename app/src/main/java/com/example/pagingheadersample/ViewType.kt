package com.example.pagingheadersample

sealed class ViewType {
    data class HeaderViewType(val id: Int, val shopName: String) : ViewType()
    data class BodyViewType(val id: Int, val makerName: String, val commodityName: String) :
        ViewType()
}