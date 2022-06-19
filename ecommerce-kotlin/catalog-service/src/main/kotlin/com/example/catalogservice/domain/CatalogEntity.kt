package com.example.catalogservice.domain

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "catalog")
data class CatalogEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val productId: String,
    val productName: String,
    val stock: Int,
    val unitPrice: Int,
    @CreationTimestamp
    val createdAt: LocalDateTime,
    @UpdateTimestamp
    val updatedAt: LocalDateTime
)
