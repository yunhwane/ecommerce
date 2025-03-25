package com.yh.product.adapter.`in`.api

import com.yh.product.adapter.`in`.request.CreateProductRequest
import com.yh.product.adapter.`in`.response.CreateProductResponse
import com.yh.product.adapter.`in`.response.Meta
import com.yh.product.adapter.`in`.response.PageProductResponse
import com.yh.product.adapter.`in`.response.ProductResponse
import com.yh.product.adapter.`in`.support.ApiResponse
import com.yh.product.application.port.`in`.ReadProductUseCase
import com.yh.product.application.port.`in`.SaveProductCommand
import com.yh.product.application.port.`in`.SaveProductUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@RestController
@RequestMapping("/api/products")
class ProductController (
    private val saveProductUseCase: SaveProductUseCase,
    private val readProductUseCase: ReadProductUseCase
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

    @GetMapping
    fun readAll(@RequestParam("categoryId") categoryId: Long,
                @RequestParam("page") page: Long,
                @RequestParam("pageSize") pageSize: Long
    ): ResponseEntity<ApiResponse<PageProductResponse>> {

        val result = readProductUseCase.readAll(categoryId, page, pageSize)

        return ResponseEntity.ok(ApiResponse.success(
            data = PageProductResponse(
                meta = Meta(
                    count = result.count
                ),
                data = result.products.map {
                    ProductResponse(
                        categoryId = it.categoryId,
                        productId = it.productId,
                        name = it.name,
                        price = it.price,
                        discountRate = it.discountRate,
                        createdAt = it.createdAt
                    )
                }
            )
        ))
    }
}