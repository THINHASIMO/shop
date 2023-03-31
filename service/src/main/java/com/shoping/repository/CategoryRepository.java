package com.shoping.repository;

import com.shoping.entity.CategoryEntity;
import com.shoping.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    @Query(
            value = "select * from category c " +
                    "where (:id is null or c.id = :id) AND c.is_deleted = 0 " +
                    "and (:parentId is null or c.parent_id = :parentId) " +
                    "and (:title is null or c.title like %:title%) " +
                    "and (:metaTitle is null or c.meta_title like %:metaTitle%) " +
                    "and (:slug is null or c.slug like %:slug%) " +
                    "and (:content is null or c.content like %:content%) ",
            nativeQuery = true)
    Page<CategoryEntity> categoryPage(
            Pageable pageable,
            @Param("id") Long id,
            @Param("parentId") Integer parentId,
            @Param("title") String title,
            @Param("metaTitle") String metaTitle,
            @Param("slug") String slug,
            @Param("content") String content
    );
}
