package com.example.catalogservice.controller

import com.example.catalogservice.dto.ResponseCatalog
import com.example.catalogservice.service.CatalogService
import org.springframework.core.env.Environment
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/catalog-service")
class CatalogController(
    private val env: Environment,
    private val catalogService: CatalogService
) {

    @GetMapping("/health_check")
    fun status(): String = "It's Working in Catalog service on Port ${env.getProperty("local.server.port")}"

    @GetMapping("/catalogs")
    fun getCatalogs(): ResponseEntity<List<ResponseCatalog>> {
        val res = arrayListOf<ResponseCatalog>()
        catalogService.getAllCatalogs().forEach{
            res.add(ResponseCatalog(it))
        }
        return ResponseEntity.ok().body(res)
    }

    @GetMapping("/catalogs/{productId}")
    fun getCatalog(@PathVariable productId: String): ResponseEntity<ResponseCatalog>{
        val catalogEntity = catalogService.getCatalogByProductId(productId)
        return ResponseEntity.ok().body(ResponseCatalog(catalogEntity))
    }
}