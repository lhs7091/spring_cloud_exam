package com.example.catalogservice.dto

import com.example.catalogservice.domain.CatalogEntity
import java.time.LocalDateTime

data class ResponseCatalog(
    val productId: String,
    val productName: String,
    val unitPrice: Int,
    val stock: Int,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
){
    constructor(catalogEntity: CatalogEntity):this(
        catalogEntity.productId,
        catalogEntity.productName,
        catalogEntity.unitPrice,
        catalogEntity.stock,
        catalogEntity.createdAt,
        catalogEntity.updatedAt
    )
}