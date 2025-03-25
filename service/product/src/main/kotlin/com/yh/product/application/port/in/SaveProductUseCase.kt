package com.yh.product.application.port.`in`

import com.yh.product.domain.ProductResult

interface SaveProductUseCase {
    fun save(command: SaveProductCommand): ProductResult
}