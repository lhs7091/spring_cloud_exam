package com.example.catalogservice.dto;

import com.example.catalogservice.domain.CatalogEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseCatalog {
    private String productId;
    private String productName;
    private Integer unitPrice;
    private Integer stock;
    private Date createdAt;

    public static ResponseCatalog fromEntity(CatalogEntity entity){
        return new ResponseCatalog(
                entity.getProductId(),
                entity.getProductName(),
                entity.getUnitPrice(),
                entity.getStock(),
                entity.getCreatedAt()
        );
    }
}
