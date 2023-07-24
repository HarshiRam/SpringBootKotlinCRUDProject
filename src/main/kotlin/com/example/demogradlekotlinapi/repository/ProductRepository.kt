package com.example.demogradlekotlinapi.repository

import com.example.demogradlekotlinapi.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Long>