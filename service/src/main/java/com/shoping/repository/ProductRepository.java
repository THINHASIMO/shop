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
                    "and (:title is null or p.title like %:title%) ",
            nativeQuery = true)
    Page<ProductEntity> findAllProductPage(
            Pageable pageable,
            @Param("id") Long id,
            @Param("title") String title
    );
}
