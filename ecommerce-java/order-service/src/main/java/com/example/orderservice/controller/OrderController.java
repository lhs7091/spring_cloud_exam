package com.example.orderservice.controller;

import com.example.orderservice.domain.OrderEntity;
import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.dto.RequestOrder;
import com.example.orderservice.dto.ResponseOrder;
import com.example.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order-service")
public class OrderController {

    private final Environment env;
    private final OrderService orderService;

    @GetMapping("/health_check")
    public String check(){
        return String.format("It's Working in Order Service on Port %s", env.getProperty("local.server.port"));
    }

    @PostMapping("/{userId}/orders")
    public ResponseEntity<ResponseOrder> createOrder(@PathVariable String userId, @RequestBody RequestOrder order){
        OrderDto orderDto = OrderDto.fromRequest(order, userId);
        OrderEntity orderEntity = orderService.createOrder(orderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseOrder.fromResponseEntity(orderEntity));
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<ResponseOrder>> getOrder(@PathVariable("userId") String userId){
        List<ResponseOrder> res = new ArrayList<>();
        Iterable<OrderEntity> orderList = orderService.getAllOrdersByUserId(userId);

        orderList.forEach(v -> res.add(ResponseOrder.fromResponseEntity(v)));

        return ResponseEntity.ok().body(res);
    }
}
