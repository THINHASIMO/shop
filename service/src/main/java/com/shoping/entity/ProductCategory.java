package com.shoping.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT_CATEGORY")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Khóa ngoại: productId, categoryId
    @ManyToOne(targetEntity = ProductEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private ProductEntity products;

    @ManyToOne(targetEntity = CategoryEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryId", referencedColumnName = "id")
    private CategoryEntity categoryEntity;
}
