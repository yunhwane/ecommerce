package com.yh.product.application.service

import com.yh.product.application.port.`in`.SaveProductCommand
import com.yh.product.application.port.`in`.SaveProductUseCase
import com.yh.product.application.port.out.SaveProductPort
import com.yh.product.domain.SaveProductResult
import org.springframework.stereotype.Service


@Service
class ProductService(
    private val saveProductPort: SaveProductPort
) : SaveProductUseCase {

    override fun save(command: SaveProductCommand): SaveProductResult {
        return saveProductPort.save(command)
    }

}
