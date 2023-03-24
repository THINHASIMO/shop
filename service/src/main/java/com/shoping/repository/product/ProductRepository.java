package com.shoping.repository.product;

import com.shoping.entity.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(
            value = "select * from product p " +
                    "where (:id is null or p.id = :id) " +
                    "and (:title is null or p.title like %:title%) ",
            nativeQuery = true)
    Page<Product> findAllProductPage(
            Pageable pageable,
            @Param("id") Integer id,
            @Param("title") String title
    );
}
