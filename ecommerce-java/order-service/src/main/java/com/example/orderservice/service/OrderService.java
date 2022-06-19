package com.example.orderservice.service;

import com.example.orderservice.domain.OrderEntity;
import com.example.orderservice.dto.OrderDto;

public interface OrderService {
    OrderEntity createOrder(OrderDto orderDetails);
    OrderEntity getOrderByOrderId(String orderId);
    Iterable<OrderEntity> getAllOrdersByUserId(String userId);
}
