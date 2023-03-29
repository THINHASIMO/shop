package com.shoping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDER_ITEM")
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantity;

    private Double price;
    private Double discount;

    private String sku;
    private String content;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date createdAt;

    //    Khóa ngoại // productId, orderId
    @ManyToOne(targetEntity = ProductEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private ProductEntity user;

    @ManyToOne(targetEntity = OrderEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "OrderId", referencedColumnName = "id")
    private OrderEntity orderEntity;
}
