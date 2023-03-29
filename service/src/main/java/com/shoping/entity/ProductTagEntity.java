package com.shoping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT_TAG")

public class ProductTagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // khóa ngoại tới : productID, tagId
    @ManyToOne(targetEntity = ProductEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private ProductEntity products;

    @ManyToOne(targetEntity = TagEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "tagId", referencedColumnName = "id")
    private TagEntity tagEntity;
}
