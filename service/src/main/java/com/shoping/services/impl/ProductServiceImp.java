package com.shoping.services.impl;

import com.shoping.dto.ProductSearchDto;
import com.shoping.entity.ProductEntity;
import com.shoping.repository.ProductRepository;
import com.shoping.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Slf4j
@Service
public class ProductServiceImp extends BaseServiceImpl<ProductEntity, Long> implements ProductService {
    private final ProductRepository repository;
    @Autowired
    private ProductService productService;

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

    @Override
    public ProductEntity getById(Long aLong) {
        return null;
    }

    @Override
    public List<ProductEntity> getByIds(Collection<Long> longs) {
        return null;
    }

    @Override
    public ProductEntity createOrUpdate(Long aLong, ProductEntity productEntity) {
        if (aLong == null) {
            super.createOrUpdate(null, productEntity);
        } else {
            var pr = productService.getById(productEntity.getId());
            super.createOrUpdate(pr.getId(), productEntity);
        }
        return productEntity;
    }

    @Override
    public boolean deleteById(Long aLong) {
        return false;
    }
}
