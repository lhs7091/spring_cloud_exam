package com.example.orderservice.service;

import com.example.orderservice.domain.OrderEntity;
import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    @Override
    public OrderEntity createOrder(OrderDto orderDetails) {
        OrderEntity orderEntity = OrderEntity.fromDtoToEntity(orderDetails);
        return orderRepository.save(orderEntity);
    }

    @Override
    public OrderEntity getOrderByOrderId(String orderId) {
        return orderRepository.findByOrderId(orderId).orElseThrow(()-> new NoSuchElementException("해당 주문이 존재하지 않습니다."));
    }

    @Override
    public Iterable<OrderEntity> getAllOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }
}
