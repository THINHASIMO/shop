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
@Table(name = "CART_ITEM")
public class CartItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantity;
    private Integer active;

    private Double price;
    private Double discount;

    private String sku;
    private String content;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date createdAt;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date updateAt;

    //    khóa ngoại: productId, cartId
    @ManyToOne(targetEntity = ProductEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private ProductEntity products;

    @ManyToOne(targetEntity = CartEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cartId", referencedColumnName = "id")
    private CartEntity cartEntity;
}
