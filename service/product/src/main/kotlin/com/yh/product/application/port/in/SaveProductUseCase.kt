package com.yh.product.application.port.`in`

import com.yh.product.domain.SaveProductResult

interface SaveProductUseCase {
    fun save(command: SaveProductCommand): SaveProductResult
}