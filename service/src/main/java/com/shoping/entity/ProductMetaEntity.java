package com.shoping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT_META")

public class ProductMetaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String key;
    private String text;

    // khóa ngoại: ProductId
    @ManyToOne (targetEntity = ProductEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private ProductEntity products;

}
