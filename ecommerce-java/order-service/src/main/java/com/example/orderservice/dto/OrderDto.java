package com.example.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto implements Serializable {
    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;

    private String orderId;
    private String userId;

    public static OrderDto fromRequest(RequestOrder order, String userId) {
        return new OrderDto(
                order.getProductId(),
                order.getQty(),
                order.getUnitPrice(),
                0,
                null,
                userId
        );
    }
}
