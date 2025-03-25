package com.yh.product.adapter.`in`.request

data class CreateProductRequest(
    val categoryId: Long,
    val name: String,
    val price: Int,
    val discountRate: Int
)
