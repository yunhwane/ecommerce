package com.yh.product.application.port.out

import com.yh.product.application.port.`in`.SaveProductCommand
import com.yh.product.domain.SaveProductResult


interface SaveProductPort {
    fun save(command: SaveProductCommand): SaveProductResult
}