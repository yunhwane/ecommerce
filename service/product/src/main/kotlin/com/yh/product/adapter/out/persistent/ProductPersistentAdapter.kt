package com.yh.product.adapter.out.persistent

import com.yh.generateSnowflakeId
import com.yh.product.adapter.out.persistent.entity.ProductEntity
import com.yh.product.application.port.`in`.SaveProductCommand
import com.yh.product.application.port.out.SaveProductPort
import com.yh.product.domain.SaveProductResult
import org.springframework.stereotype.Component
import java.time.LocalDateTime


@Component
class ProductPersistentAdapter(
    private val productRepository: ProductRepository,

) : SaveProductPort{
    override fun save(command: SaveProductCommand): SaveProductResult {

        val entity = ProductEntity(
            productId = generateSnowflakeId(),
            categoryId = command.categoryId,
            createdAt = LocalDateTime.now(),
            name = command.name,
            price = command.price,
            discountRate = command.discountRate,
        )

        return productRepository.save(entity).let {
            SaveProductResult(
                productId = it.productId,
                categoryId = it.categoryId,
                name = it.name,
                price = it.price,
                discountRate = it.discountRate,
                createdAt = it.createdAt,
            )
        }
    }
}