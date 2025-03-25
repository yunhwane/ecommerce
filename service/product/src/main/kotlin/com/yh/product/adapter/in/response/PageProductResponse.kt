package com.yh.product.adapter.`in`.response

import java.time.LocalDateTime

data class PageProductResponse(
    private val meta: Meta,
    private val data: List<ProductResponse>
)

data class ProductResponse(
    val categoryId: Long,
    val productId: Long,
    val name: String,
    val price: Int,
    val discountRate: Int,
    val createdAt: LocalDateTime,
)

data class Meta(
    val count: Long = 0,
)