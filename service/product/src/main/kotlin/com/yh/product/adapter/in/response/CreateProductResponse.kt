package com.yh.product.adapter.`in`.response

import java.time.LocalDateTime

data class CreateProductResponse (
    val categoryId: Long,
    val productId: Long,
    val name: String,
    val price: Int,
    val discountRate: Int,
    val createdAt: LocalDateTime,
){
}