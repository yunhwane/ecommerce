package com.yh.product.application.port.`in`

data class SaveProductCommand (
    val name: String,
    val categoryId: Long,
    val price: Int,
    val discountRate: Int
){
}