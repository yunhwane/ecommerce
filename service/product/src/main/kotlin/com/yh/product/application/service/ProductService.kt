package com.yh.product.application.service

import com.yh.product.application.port.`in`.ReadProductUseCase
import com.yh.product.application.port.`in`.SaveProductCommand
import com.yh.product.application.port.`in`.SaveProductUseCase
import com.yh.product.application.port.out.ReadProductPort
import com.yh.product.application.port.out.SaveProductPort
import com.yh.product.domain.ProductPageResult
import com.yh.product.domain.ProductResult
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class ProductService(
    private val saveProductPort: SaveProductPort,
    private val readProductPort: ReadProductPort,
) : SaveProductUseCase, ReadProductUseCase {

    @Transactional
    override fun save(command: SaveProductCommand): ProductResult {
        return saveProductPort.save(command)
    }

    @Transactional(readOnly = true)
    override fun readAll(categoryId: Long, page: Long, pageSize: Long): ProductPageResult {
        return ProductPageResult(
            products = readProductPort.findAll(categoryId,
                offset = (page - 1) * pageSize, limit = pageSize).map {
                    ProductResult(
                        productId = it.productId,
                        categoryId = it.categoryId,
                        name = it.name,
                        price = it.price,
                        discountRate = it.discountRate,
                        createdAt = it.createdAt
                    )
            },
            count = readProductPort.count(categoryId,
                PageLimitCalculator.calculatePageLimit(page, pageSize, 10L))
        )
    }


}
