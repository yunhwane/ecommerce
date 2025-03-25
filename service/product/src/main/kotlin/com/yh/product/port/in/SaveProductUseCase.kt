package com.yh.product.port.`in`

import com.yh.product.domain.SaveProductResult

interface SaveProductUseCase {
    fun save(command: SaveProductCommand): SaveProductResult
}