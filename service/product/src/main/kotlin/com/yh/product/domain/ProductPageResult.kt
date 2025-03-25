package com.yh.product.domain

data class ProductPageResult (
    val products: List<ProductResult>,
    val count: Long
){

}