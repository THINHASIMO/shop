package com.shoping.entity.product;

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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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
    private int pageIndex;
    private int pageSize;
    public int getOrDefaultPageIndex() {
        return pageIndex <= 0 ? 0 : pageIndex - 1;
    }
    public int getOrDefaultPageSize() {
        return pageSize == 0 ? 10 : pageSize;
    }

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateTime;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date updatedAt;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date publishedAt;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date startAt;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date endsAt;
}

