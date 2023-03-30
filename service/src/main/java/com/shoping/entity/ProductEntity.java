package com.shoping.entity;

import com.shoping.entity.common.BaseEntity;
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
@Table(name = "PRODUCT")
public class ProductEntity extends BaseEntity {

    private Integer quantity;
    private Long price;

    private String title;
    private String metaTitle;
    private String slug;
    private String summary;
    private String type;
    private String sku;
    private String discount;
    private String shop;
    private String content;

    // Search
}

