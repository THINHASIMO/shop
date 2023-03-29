package com.shoping.services;

import com.shoping.dto.ProductSearchDto;
import com.shoping.entity.ProductEntity;
import com.shoping.services.common.BaseSearchService;
import com.shoping.services.common.BaseService;

public interface ProductService extends BaseService<ProductEntity, Long>,   BaseSearchService<ProductEntity, ProductSearchDto> {
}
