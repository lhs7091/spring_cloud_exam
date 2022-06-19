package com.example.orderservice.dto;

import com.example.orderservice.domain.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseOrder {
    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;

    private String orderId;

    public static ResponseOrder fromResponseEntity(OrderEntity orderEntity) {
        return new ResponseOrder(
                orderEntity.getProductId(),
                orderEntity.getQty(),
                orderEntity.getUnitPrice(),
                orderEntity.getTotalPrice(),
                orderEntity.getOrderId()
        );

    }
}
