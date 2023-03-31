package com.shoping.repository;

import com.shoping.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    @Query(
            value = "select * from product p " +
                    "where (:id is null or p.id = :id) AND p.is_deleted = 0 " +
                    "and (:price is null or p.price = price) " +
                    "and (:quantity is null or p.quantity = quantity) " +
                    "and (:title is null or p.title like %:title%) " +
                    "and (:metaTitle is null or p.meta_title like %:metaTitle%) " +
                    "and (:slug is null or p.slug like %:slug%) " +
                    "and (:summary is null or p.summary like %:summary%) " +
                    "and (:type is null or p.type like %:type%) " +
                    "and (:sku is null or p.sku like %:sku%) " +
                    "and (:discount is null or p.discount like %:discount%) " +
                    "and (:shop is null or p.shop like %:shop%) " +
                    "and (:content is null or p.content like %:content%) ",

            nativeQuery = true)
    Page<ProductEntity> productPage(
            Pageable pageable,
            @Param("id") Long id,
            @Param("price") Long price,
            @Param("quantity") Integer quantity,

            @Param("title") String title,
            @Param("metaTitle") String metaTitle,
            @Param("slug") String slug,
            @Param("summary") String summary,
            @Param("type") String type,
            @Param("sku") String sku,
            @Param("discount") String discount,
            @Param("shop") String shop,
            @Param("content") String content
    );
}
