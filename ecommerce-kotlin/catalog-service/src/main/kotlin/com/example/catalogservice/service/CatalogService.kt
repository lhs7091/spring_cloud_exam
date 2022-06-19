package com.example.catalogservice.service

import com.example.catalogservice.domain.CatalogEntity
import com.example.catalogservice.repository.CatalogRepository
import org.springframework.stereotype.Service
import javax.naming.NameNotFoundException

@Service
class CatalogService(
    private val catalogRepository: CatalogRepository
) {
    fun getCatalogByProductId(productId: String): CatalogEntity
        = catalogRepository.findByProductId(productId)
        .orElseThrow { throw NameNotFoundException("Product not Found") }

    fun getAllCatalogs(): List<CatalogEntity> = catalogRepository.findAll()
}