package com.shoping.services.impl;

import com.shoping.dto.CategorySearchDto;
import com.shoping.entity.CategoryEntity;
import com.shoping.repository.CategoryRepository;
import com.shoping.services.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CategoryServiceImpl extends BaseServiceImpl<CategoryEntity, Long> implements CategoryService {
    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        super(repository);
        this.repository = repository;
    }


    @Override
    public Page<CategoryEntity> page(CategorySearchDto categorySearchDto) {
        return repository.categoryPage(
                PageRequest.of(categorySearchDto.getOrDefaultPageIndex(), categorySearchDto.getOrDefaultPageSize()),
                categorySearchDto.getId(),
                categorySearchDto.getParentId(),
                categorySearchDto.getTitle(),
                categorySearchDto.getMetaTitle(),
                categorySearchDto.getSlug(),
                categorySearchDto.getContent()
        );
    }
}
