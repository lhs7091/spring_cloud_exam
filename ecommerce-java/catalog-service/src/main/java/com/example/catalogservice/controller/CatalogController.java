package com.example.catalogservice.controller;

import com.example.catalogservice.dto.ResponseCatalog;
import com.example.catalogservice.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/catalog-service")
public class CatalogController {

    private final Environment env;
    private final CatalogService catalogService;

    @GetMapping("/health_check")
    public String status(){
        return String.format("It's Working in Catalog Service on PORT %s", env.getProperty("local.server.port"));
    }

    @GetMapping("/catalogs")
    public ResponseEntity<List<ResponseCatalog>> getCatalogs(){
        List<ResponseCatalog> res = new ArrayList<>();

        catalogService.getAllCatalogs().forEach(v -> res.add(ResponseCatalog.fromEntity(v)));

        return ResponseEntity.ok().body(res);
    }

}
