package com.example.catalogservice.repository

import com.example.catalogservice.domain.CatalogEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CatalogRepository: JpaRepository<CatalogEntity, Long> {
    fun findByProductId(productId: String): Optional<CatalogEntity>
}