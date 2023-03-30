package com.shoping.services.impl;

import com.shoping.dto.ProductSearchDto;
import com.shoping.entity.ProductEntity;
import com.shoping.repository.ProductRepository;
import com.shoping.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductServiceImp extends BaseServiceImpl<ProductEntity, Long> implements ProductService {
    private final ProductRepository repository;

    public ProductServiceImp(ProductRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Page<ProductEntity> page(ProductSearchDto productSearchDto) {
        return repository.findAllProductPage(
                PageRequest.of(productSearchDto.getOrDefaultPageIndex(), productSearchDto.getOrDefaultPageSize()),
                productSearchDto.getId(),
                productSearchDto.getTitle());
    }

}
