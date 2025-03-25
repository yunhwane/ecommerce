package com.yh.product.application.port.out

import com.yh.product.domain.ProductResult


interface ReadProductPort {
    fun findAll(categoryId: Long, offset: Long, limit: Long): List<ProductResult>
    fun count(categoryId: Long, limit: Long): Long
}