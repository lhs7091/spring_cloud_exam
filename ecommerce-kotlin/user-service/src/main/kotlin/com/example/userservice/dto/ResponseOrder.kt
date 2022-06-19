package com.example.userservice.dto

import java.time.LocalDateTime

data class ResponseOrder(
    val productId: String,
    val qty: Int,
    val unitPrice: Int,
    val totalPrice: Int,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val orderId: String,
)
