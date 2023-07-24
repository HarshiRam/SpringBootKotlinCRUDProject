package com.example.demogradlekotlinapi.model

import jakarta.persistence.*

@Entity
@Table(name = "tb_product")
data class Product(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long,
    val productname: String,
    val price: Float,
    val qty: Int
)