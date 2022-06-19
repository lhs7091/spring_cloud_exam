package com.example.orderservice.domain;

import com.example.orderservice.dto.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class OrderEntity implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120, unique = true)
    private String productId;
    @Column(nullable = false)
    private Integer qty;
    @Column(nullable = false)
    private Integer unitPrice;
    @Column(nullable = false)
    private Integer totalPrice;
    @Column(nullable = false)
    private String userId;
    @Column(nullable = false, unique = true)
    private String orderId;

    @Column(nullable = false, updatable = false, insertable = false)
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private Date createdAt;

    public static OrderEntity fromDtoToEntity(OrderDto orderDetails) {
        return new OrderEntity(
                0L,
                orderDetails.getProductId(),
                orderDetails.getQty(),
                orderDetails.getUnitPrice(),
                orderDetails.getQty() * orderDetails.getUnitPrice(),
                orderDetails.getUserId(),
                UUID.randomUUID().toString(),
                null
        );
    }
}
