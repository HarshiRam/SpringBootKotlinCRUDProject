package com.example.demogradlekotlinapi.controller

import com.example.demogradlekotlinapi.model.Product
import com.example.demogradlekotlinapi.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("api/v1/products")
@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
class ProductController(val service: ProductService) {
    @GetMapping
    fun getAllProducts() = service.getAll()

    @GetMapping("/{id}")
    fun getProduct(@PathVariable id: Long) = service.getById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveProduct(@RequestBody product: Product): Product = service.create(product)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteProduct(@PathVariable id: Long) = service.remove(id)

    @PutMapping("/{id}")
    fun updateProduct(
        @PathVariable id: Long, @RequestBody product: Product
    ) = service.update(id, product)
}