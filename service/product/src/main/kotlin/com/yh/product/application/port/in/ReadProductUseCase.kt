package com.yh.product.application.port.`in`

import com.yh.product.domain.ProductPageResult



interface ReadProductUseCase {
    fun readAll(categoryId: Long, page: Long, pageSize: Long): ProductPageResult
}