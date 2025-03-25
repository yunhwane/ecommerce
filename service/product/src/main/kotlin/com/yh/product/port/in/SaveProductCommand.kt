package com.yh.product.port.`in`

data class SaveProductCommand (
    val name: String,
    val price: Int,
    val stock: Int,
    val discountRate: Int
){
}