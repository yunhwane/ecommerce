package com.yh.product.adapter.`in`.request

data class CreateProductRequest(
    val name: String,
    val price: Int,
    val stock: Int,
    val discountRate: Int
)
