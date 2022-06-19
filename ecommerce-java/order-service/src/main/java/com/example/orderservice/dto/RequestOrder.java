package com.example.orderservice.dto;

import lombok.Getter;

@Getter
public class RequestOrder {
    private String productId;
    private Integer qty;
    private Integer unitPrice;
}
