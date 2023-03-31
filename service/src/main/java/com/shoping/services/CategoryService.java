package com.shoping.services;

import com.shoping.dto.CategorySearchDto;
import com.shoping.entity.CategoryEntity;
import com.shoping.services.common.BaseSearchService;
import com.shoping.services.common.BaseService;

public interface CategoryService extends BaseService<CategoryEntity, Long>, BaseSearchService<CategoryEntity, CategorySearchDto> {
}

