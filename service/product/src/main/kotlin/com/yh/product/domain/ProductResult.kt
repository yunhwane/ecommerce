package com.yh.product.domain

import java.time.LocalDateTime

data class ProductResult (
    val categoryId: Long,
    val productId: Long,
    val name: String,
    val price: Int,
    val discountRate: Int,
    val createdAt: LocalDateTime,
){

}