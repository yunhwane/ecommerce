package com.yh.product.application.port.out

import com.yh.product.application.port.`in`.SaveProductCommand
import com.yh.product.domain.ProductResult


interface SaveProductPort {
    fun save(command: SaveProductCommand): ProductResult
}