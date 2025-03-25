package com.yh.product.adapter.out.persistent

import com.yh.generateSnowflakeId
import com.yh.product.adapter.out.persistent.entity.ProductEntity
import com.yh.product.application.port.`in`.SaveProductCommand
import com.yh.product.application.port.out.ReadProductPort
import com.yh.product.application.port.out.SaveProductPort
import com.yh.product.domain.ProductResult
import org.springframework.stereotype.Component
import java.time.LocalDateTime


@Component
class ProductPersistentAdapter(
    private val productRepository: ProductRepository,

) : SaveProductPort, ReadProductPort{
    override fun save(command: SaveProductCommand): ProductResult {

        val entity = ProductEntity(
            productId = generateSnowflakeId(),
            categoryId = command.categoryId,
            createdAt = LocalDateTime.now(),
            name = command.name,
            price = command.price,
            discountRate = command.discountRate,
        )

        return productRepository.save(entity).let {
            ProductResult(
                productId = it.productId,
                categoryId = it.categoryId,
                name = it.name,
                price = it.price,
                discountRate = it.discountRate,
                createdAt = it.createdAt,
            )
        }
    }

    override fun findAll(
        categoryId: Long,
        offset: Long,
        limit: Long,
    ): List<ProductResult> {
        return productRepository.findAll(
            categoryId = categoryId,
            limit = limit,
            offset = offset
        ).map {
            ProductResult(
                productId = it.productId,
                categoryId = it.categoryId,
                name = it.name,
                price = it.price,
                discountRate = it.discountRate,
                createdAt = it.createdAt,
            )
        }
    }

    override fun count(categoryId: Long, limit: Long): Long {
        return productRepository.count(categoryId, limit)
    }


}