package com.yh.product.adapter.`in`.response

data class CreateProductResponse (
    val productId: Long,
    val name: String,
    val price: Int,
    val discountRate: Int,
    val stock: Int
){
}