package com.yh.product.adapter.`in`.api

import com.yh.product.adapter.`in`.request.CreateProductRequest
import com.yh.product.adapter.`in`.response.CreateProductResponse
import com.yh.product.adapter.`in`.support.ApiResponse
import com.yh.product.application.port.`in`.SaveProductCommand
import com.yh.product.application.port.`in`.SaveProductUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/api/products")
class ProductController (
    private val saveProductUseCase: SaveProductUseCase
){

    @PostMapping
    fun save(@RequestBody request: CreateProductRequest): ResponseEntity<ApiResponse<CreateProductResponse>> {
        val command = SaveProductCommand(
            categoryId = request.categoryId,
            name = request.name,
            price = request.price,
            discountRate = request.discountRate
        )

        val result = saveProductUseCase.save(command)

        return ResponseEntity.ok(ApiResponse.success(
            data = CreateProductResponse(
                categoryId = result.categoryId,
                productId = result.productId,
                name = result.name,
                price = result.price,
                discountRate = result.discountRate,
                createdAt = result.createdAt
            )
        ))
    }
}