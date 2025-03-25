package com.yh.product.adapter.`in`.api

import com.yh.product.adapter.`in`.request.CreateProductRequest
import com.yh.product.adapter.`in`.response.CreateProductResponse
import com.yh.product.adapter.`in`.support.ApiResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/api/products")
class ProductController (
    private final val readProductUseCase: ReadProductUseCase
){

    @PostMapping
    fun create(@RequestBody request: CreateProductRequest): ResponseEntity<ApiResponse<CreateProductResponse>> {
        TODO()
    }
}