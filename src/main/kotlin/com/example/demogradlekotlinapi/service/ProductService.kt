package com.example.demogradlekotlinapi.service

import com.example.demogradlekotlinapi.model.Product
import com.example.demogradlekotlinapi.repository.ProductRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ProductService(val repository: ProductRepository) {
    fun getAll(): List<Product> = repository.findAll()

    fun getById(id: Long): Product = repository.findByIdOrNull(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    fun create(product: Product): Product = repository.save(product)

    fun remove(id: Long) {
        if (repository.existsById(id)) repository.deleteById(id)
        else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    fun update(id: Long, product: Product): Product {
        return if (repository.existsById(id)) {
            product.id = id
            repository.save(product)
        } else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }
}