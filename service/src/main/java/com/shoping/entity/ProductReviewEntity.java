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
@Table(name = "PRODUCT_REVIEW")
public class ProductReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer rating;
    private Integer published;

    private String title;
    private String content;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date createdAt;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date publishedAt;

    // khóa ngoại: ProductId
    @ManyToOne(targetEntity = ProductEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private ProductEntity products;
    // ParentId khóa ngoại tới chính nó ???

}
