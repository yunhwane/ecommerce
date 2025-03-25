package com.yh.product.domain

data class SaveProductResult (
    val productId: Long,
    val name: String,
    val price: Int,
    val discountRate: Int,
){

}