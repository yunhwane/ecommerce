package com.yh.product.adapter.out.persistent.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity(name = "product")
class ProductEntity (

    @Id
    val productId: Long,
    val categoryId: Long,
    val name: String,
    val price: Int,
    val discountRate: Int,
    val createdAt: LocalDateTime
){
}