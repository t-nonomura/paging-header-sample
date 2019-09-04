package com.example.pagingheadersample

interface Item {
    val id: Int
}

data class Header(
    override val id: Int,
    val shopName: String
) : Item

data class Body(
    override val id: Int,
    val makerName: String,
    val commodityName: String
) : Item

