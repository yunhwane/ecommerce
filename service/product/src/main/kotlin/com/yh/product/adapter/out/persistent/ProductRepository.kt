package com.yh.product.adapter.out.persistent

import com.yh.product.adapter.out.persistent.entity.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ProductRepository : JpaRepository<ProductEntity, Long> {

    @Query(
        value = """
            select product.product_id, product.category_id, product.name, product.price, product.discount_rate, product.created_at
            from (
                select product_id from product
                where category_id = :categoryId
                order by product_id desc
                limit :limit offset :offset
            ) t left join product on t.product_id = product.product_id
        """, nativeQuery = true
    )
    fun findAll(@Param("categoryId") categoryId: Long, @Param("limit") limit: Int, @Param("offset") offset: Int): List<ProductEntity>
}